package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Dao<T> {

	@PersistenceContext(unitName = "des")
	protected EntityManager em;
	
	public Dao(EntityManager em){
		this.em = em;
	}
	
	public Dao(){
		
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
