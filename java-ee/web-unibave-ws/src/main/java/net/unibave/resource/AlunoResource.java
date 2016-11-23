package net.unibave.resource;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.unibave.domain.Aluno;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlunoResource {

	private static final Logger logger = LogManager.getLogger(AlunoResource.class.getSimpleName());

        @Inject
        private EntityManager em;
    
	@GET
	public List<Aluno> findAll() {
            List<Aluno> alunos = em.createQuery("FROM Aluno a", Aluno.class)
                    .getResultList();
            return alunos;
	}

	@GET
	@Path("{id}")
	public Aluno findById(@PathParam("id") Long id) {
            return em.find(Aluno.class, id);
	}

	@POST
	public Aluno create(Aluno aluno) {
            em.persist(aluno);
            return aluno;
	}

	@PUT
	public Aluno update(Aluno aluno) {
            return em.merge(aluno);
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
            Aluno aluno = em.find(Aluno.class, id);
            em.remove(aluno);
            return Response.noContent().build();
	}
	
	@GET
        @Path("relatorio")
	public List<Aluno> relatorio(@QueryParam("id") Long id,
                @QueryParam("nome") String nome,
                @QueryParam("dataNascimento") Date dataNascimento) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Aluno> cq = em.getCriteriaBuilder().createQuery(Aluno.class);
            Root<Aluno> pet = cq.from(Aluno.class);
            cq.select(pet);
            if (id != null) {
                cq.where(cb.equal(pet.get("id"), id));
            }
            if (nome != null) {
                cq.where(cb.equal(pet.get("nome"), nome));
            }
            if (dataNascimento != null) {
                cq.where(cb.equal(pet.get("dataNascimento"), dataNascimento));
            }
            TypedQuery<Aluno> q = em.createQuery(cq);
            List<Aluno> alunos = q.getResultList();
            return alunos;
	}
	
}
