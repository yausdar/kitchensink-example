package model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entity.Usuario;

@Stateless
public class UsuarioDao extends BaseDao<Usuario> {

	public UsuarioDao(EntityManager em) {
		super(em);
	}

	public UsuarioDao() {

	}

	public Usuario login(Usuario u) {
		TypedQuery<Usuario> query = em
				.createNamedQuery("Usuario.login", Usuario.class)
				.setParameter("email", u.getEmail())
				.setParameter("senha", u.getSenha());

		List<Usuario> resultList = query.getResultList();
		if (resultList.isEmpty()) {
			return null;
		} else {
			return resultList.get(0);
		}
	}

	public Usuario findByEmail(String email) {
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByEmail",
				Usuario.class).setParameter("email", email);
		if (query.getResultList().isEmpty()) {
			return null;
		}
		return query.getResultList().get(0);
	}

	public List<Usuario> getAll() {
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.getAll",
				Usuario.class);
		return query.getResultList();
	}

	public void save(Usuario user) {
		em.merge(user);
	}

}
