package service;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import auth.AuthException;
import dao.UsuarioDao;
import entity.Usuario;

@Stateful
public class SessaoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5378374082079727780L;

	private Usuario usuario;

	@EJB
	private UsuarioDao usuarioDao;

	public void login(String email, String senha) {
		usuario = usuarioDao.login(email, senha);
		if (usuario == null) {
			throw new AuthException(AuthException.ACCESS_DENIED);
		}
	}

	public void logout() {
		usuario = null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
