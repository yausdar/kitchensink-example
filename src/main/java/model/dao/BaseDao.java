package model.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BaseDao<T> {

	@PersistenceContext(unitName = "dev")
	protected EntityManager em;
	
	public BaseDao(EntityManager em){
		this.em = em;
	}
	
	public BaseDao(){
		
	}
	
	public void save(T entity) {
		em.persist(entity);
	}

	public void update(T entity) {
		em.merge(entity);
	}

	public void remove(T entity) {
		em.remove(em.merge(entity));
	}
	
}
