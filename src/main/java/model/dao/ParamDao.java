package model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entity.Param;

@Stateless
public class ParamDao extends BaseDao<Param> {

	public ParamDao(EntityManager em) {
		super(em);
	}

	public ParamDao() {

	}

	public List<Param> getListaParam() {
		TypedQuery<Param> query = em.createNamedQuery("Param.getAll",
				Param.class);
		return query.getResultList();
	}

}
