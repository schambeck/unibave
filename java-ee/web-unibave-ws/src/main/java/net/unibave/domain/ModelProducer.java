package net.unibave.domain;

//import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Dependent
public class ModelProducer {
    
    @Produces
    @Default
    @PersistenceContext(unitName = "unibavePU")
    private EntityManager em;

//    @Produces
//    public JPAQueryFactory createJPAQueryFactory() {
//        return new JPAQueryFactory(em);
//    }
    
}
