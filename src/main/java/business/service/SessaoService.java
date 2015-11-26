package business.service;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import util.Hash;
import util.security.AuthException;
import util.security.Role;
import model.dao.UsuarioDao;
import model.entity.Usuario;

@Stateful
public class SessaoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5378374082079727780L;

	private Usuario usuario;

	@EJB
	private UsuarioDao usuarioDao;
	
	@EJB
	private Hash hashUtil;

	public void login(Usuario u) {
		u.setSenha(hashUtil.md5(u.getSenha()));
		this.usuario = usuarioDao.login(u);
		if(usuario == null) {
			throw new AuthException(AuthException.ACCESS_DENIED);
		}
	}

	public void logout() {
		usuario = null;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public boolean isAdmin(){
		Usuario usuario = getUsuario();
		if(usuario != null && usuario.getListaPapel() != null && usuario.getListaPapel().contains(Role.ADMIN)){
			return true;
		}
		
		return false;
	}

}
