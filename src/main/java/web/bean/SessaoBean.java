package web.bean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.entity.Usuario;
import business.service.SessaoService;

@Named
@SessionScoped
public class SessaoBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8143226417616212359L;

	@EJB
	private SessaoService sessaoService;

	private String email;
	private String senha;

	public Usuario getUsuario() {
		return sessaoService.getUsuario();
	}

	public String login() {
		try {
			sessaoService.login(new Usuario(email , senha));
			return "/index.xhtml?faces-redirect=true";
		} catch (Exception e) {
			facesUtil.addError(e.getMessage());
		}
		return null;
	}

	public String logout() {
		sessaoService.logout();
		return "/index.xhtml?faces-redirect=true";
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
