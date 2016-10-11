package net.unibave.showcase.resource;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.unibave.showcase.model.Carro;
import net.unibave.showcase.model.Categoria;
import net.unibave.showcase.model.QCarro;
import net.unibave.showcase.model.QCategoria;

@RequestScoped
public class CarroResource {
    
    @Inject
    private EntityManager em;
    
    @Inject
    private JPAQueryFactory queryFactory;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@QueryParam("nome") String nome) {
        List<Predicate> predicates = new ArrayList<>();
        if (nome != null) {
            predicates.add(QCarro.carro.nome.containsIgnoreCase(nome));
        }
        List<Carro> carros = queryFactory.selectFrom(QCarro.carro)
                .where(predicates.toArray(new Predicate[predicates.size()]))
                .fetch();
        return Response.ok(carros).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("create")
    public Response create() {
        Categoria categoria = queryFactory.selectFrom(QCategoria.categoria)
                .where(QCategoria.categoria.id.eq(1L))
                .fetchOne();
//        Categoria categoria = (Categoria) em.createQuery("FROM Categoria c WHERE c.id = 1 ORDER BY nome").getSingleResult();
        List<Carro> carros = Carro.getCarros();
        for (Carro carro : carros) {
            carro.setCategoria(categoria);
            em.persist(carro);
        }
        return Response.ok(carros).build();
    }
    
}
