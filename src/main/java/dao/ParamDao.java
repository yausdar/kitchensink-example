package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entity.Param;

@Stateless
public class ParamDao extends Dao<Param> {

	public ParamDao(EntityManager em) {
		super(em);
	}
	
	public ParamDao(){
		
	}

	public List<Param> getAll() {
		TypedQuery<Param> query = em.createNamedQuery("Param.getAll",
				Param.class);
		return query.getResultList();
	}

	public Map<String, String> getMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		List<Param> listaParam = getAll();
		for (Param p : listaParam) {
			map.put(p.getChave(), p.getValor());
		}
		return map;
	}

}
