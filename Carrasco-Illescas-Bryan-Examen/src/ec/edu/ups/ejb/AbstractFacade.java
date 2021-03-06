package ec.edu.ups.ejb;


import java.util.List;

import javax.persistence.EntityManager;

public abstract class AbstractFacade<T> {

	private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
	this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
	getEntityManager().persist(entity);
    }
    
    public T find(Object id) {
	return getEntityManager().find(entityClass, id);
    }
    public List<T> findAll() {
    	javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    	cq.select(cq.from(entityClass));
    	return getEntityManager().createQuery(cq).getResultList();
        }


}