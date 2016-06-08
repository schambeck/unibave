package net.unibave.showcase.resource;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.unibave.showcase.model.Carro;
import net.unibave.showcase.model.QCarro;

@RequestScoped
public class CarroCategoriaResource {
    
    @Inject
    private JPAQueryFactory queryFactory;

    @PathParam("codigoCategoria")
    private Long codigoCategoria;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@QueryParam("nome") String nome) {
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(QCarro.carro.categoria.id.eq(codigoCategoria));
        if (nome != null) {
            predicates.add(QCarro.carro.nome.containsIgnoreCase(nome));
        }
        List<Carro> carros = queryFactory.selectFrom(QCarro.carro)
                .where(predicates.toArray(new Predicate[predicates.size()]))
                .fetch();
        return Response.ok(carros).build();
    }
    
}
