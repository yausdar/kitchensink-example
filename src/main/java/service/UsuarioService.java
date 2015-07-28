package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.validation.Valid;

import logger.LoggerInterceptor;
import auth.AuthInterceptor;
import auth.Role;
import auth.RolesAllowed;
import dao.UsuarioDao;
import entity.Usuario;
import exception.BusinessRuleException;

@Stateless
public class UsuarioService {

	@EJB
	private UsuarioDao usuarioDao;

	public void saveUsuario(@Valid Usuario user) {
		if (!user.getSenha().equals(user.getConfirmacaoSenha())) {
			throw new BusinessRuleException("Senha não confere!");
		}
		if(usuarioDao.findByEmail(user.getEmail()) != null){
			throw new BusinessRuleException("Já existe um usuário cadastrado com esse email!");
		}
		user.getListaPapel().clear();
		user.getListaPapel().add(Role.USER);
		usuarioDao.save(user);
	}
	
	
	@RolesAllowed(Role.ADMIN)
	public void saveAdmin(@Valid Usuario user){
		user.getListaPapel().add(Role.ADMIN);
		saveUsuario(user);
	}

	@RolesAllowed(Role.ADMIN)
	public List<Usuario> getAll() {
		return usuarioDao.getAll();
	}

}
