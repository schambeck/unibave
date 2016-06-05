package net.unibave.showcase.resource;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Stateless
@Path("/")
public class ApiResource {

    @Inject
    private CarroResource carroResource;

    @Inject
    private CategoriaResource categoriaResource;

    @Path("carro")
    public CarroResource getCarroResource() {
        return carroResource;
    }
    
    @Path("categoria")
    public CategoriaResource getCategoriaResource() {
        return categoriaResource;
    }
    
}
