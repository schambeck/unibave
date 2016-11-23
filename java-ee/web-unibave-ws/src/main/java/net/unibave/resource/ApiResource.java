package net.unibave.resource;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/")
public class ApiResource {

    @Inject
    private AlunoResource alunoResource;

    @Path("alunos")
    public AlunoResource getAlunoResource() {
        return alunoResource;
    }
    
}
