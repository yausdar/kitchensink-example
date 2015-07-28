package bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import entity.Usuario;
import service.SessaoService;
import util.Faces;
import auth.Role;

@Named
@SessionScoped
public class SessaoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6407510137250538867L;

	@EJB
	private SessaoService sessaoService;

	private String email;
	private String senha;
	
	public Usuario getUsuario() {
		return sessaoService.getUsuario();
	}

	public String login() {
		try {
			sessaoService.login(email, senha);
			return "/index.xhtml?faces-redirect=true";
		} catch (Exception e) {
			Faces.addError(e.getMessage());
		}
		return null;
	}

	public String logout() {
		sessaoService.logout();
		return "/index.xhtml?faces-redirect=true";
	}

	public boolean isAdmin(){
		Usuario usuario = getUsuario();
		if(usuario != null && usuario.getListaPapel() != null && usuario.getListaPapel().contains(Role.ADMIN)){
			return true;
		}
		
		return false;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
