package net.unibave.showcase.resource;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marcelo
 */
@Dependent
public class ModelProducer {
    
    @Produces
    @Default
    @PersistenceContext(unitName = "showcasePU")
    private EntityManager em;

//    @Produces
//    public JPAQueryFactory createJPAQueryFactory() {
//        return new JPAQueryFactory(em);
//    }
    
}
