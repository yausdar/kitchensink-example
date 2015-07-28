package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entity.Usuario;
import util.Hash;

@Stateless
public class UsuarioDao extends Dao<Usuario> {
	
	public UsuarioDao(EntityManager em){
		super(em);
	}
	
	public UsuarioDao(){
		
	}

	public Usuario login(String email , String senha){
		
		if(email == null || senha == null){
			return null;
		}
		
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.login" , Usuario.class)
			.setParameter("email", email)
			.setParameter("senha", Hash.md5(senha));
		
		List<Usuario> resultList = query.getResultList();
		if(resultList.isEmpty()){
			return null;
		}else{
			return resultList.get(0);
		}	
	}
	
	public Usuario findByEmail(String email){
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByEmail" , Usuario.class)
				.setParameter("email", email);
		if(query.getResultList().isEmpty()){
			return null;	
		}
		return query.getResultList().get(0);
	}
	
	public List<Usuario> getAll(){
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.getAll" , Usuario.class);
		return query.getResultList();
	}
	
	public void save(Usuario user){
		user.setSenha(Hash.md5(user.getSenha()));
		em.merge(user);
	}

}
