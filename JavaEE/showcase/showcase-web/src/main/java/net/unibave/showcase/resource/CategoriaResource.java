package net.unibave.showcase.resource;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.unibave.showcase.model.Categoria;
import net.unibave.showcase.model.QCategoria;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @PersistenceContext(unitName = "showcasePU")
    private EntityManager em;

    @GET
    public Response findAll() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Categoria> categorias = queryFactory.selectFrom(QCategoria.categoria)
                .fetch();
//        List<Categoria> categorias = em.createQuery("FROM Categoria c ORDER BY c.nome").getResultList();;
        return Response.ok(categorias).build();
    }
    
}
