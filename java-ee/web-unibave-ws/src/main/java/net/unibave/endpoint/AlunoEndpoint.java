package net.unibave.endpoint;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import net.unibave.domain.Aluno;

@WebService
@Stateless
public class AlunoEndpoint {

    @Inject
    private EntityManager em;
    
    @WebMethod
    @WebResult(name = "aluno")
    public List<Aluno> findAll() {
        return em.createQuery("FROM Aluno a", Aluno.class).getResultList();
    }
    
    @WebMethod
    @WebResult(name = "aluno")
    public Aluno findById(@WebParam(name = "id") Long id) {
        return em.find(Aluno.class, id);
    }
    
    @WebMethod
    @WebResult(name = "aluno")
    public Aluno save(@WebParam(name = "aluno") Aluno aluno) {
        em.persist(aluno);
        return aluno;
    }

    @WebMethod
    public void remove(@WebParam(name = "id") Long id) {
        Aluno aluno = em.find(Aluno.class, id);
        em.remove(aluno);
    }
    
}
