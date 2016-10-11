package net.unibave.showcase.resource;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.unibave.showcase.model.Categoria;
import net.unibave.showcase.model.QCategoria;

@RequestScoped
public class CategoriaResource {

    @Inject
    private JPAQueryFactory queryFactory;

    @Context
    private ResourceContext context;
        
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Categoria> categorias = queryFactory.selectFrom(QCategoria.categoria)
                .fetch();
//        List<Categoria> categorias = em.createQuery("FROM Categoria c ORDER BY c.nome").getResultList();;
        return Response.ok(categorias).build();
    }

    @Path("{codigoCategoria}/carro")
    public CarroCategoriaResource carro() {
        return context.getResource(CarroCategoriaResource.class);
    }
    
}
