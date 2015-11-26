package web.bean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.entity.Usuario;
import util.Faces;
import business.service.UsuarioService;

@Named
@RequestScoped
public class UsuarioBean {

	@EJB
	private Faces facesUtil;

	private Usuario usuario = new Usuario();

	@EJB
	private UsuarioService usuarioService;

	public void save() {
		try {
			usuarioService.save(usuario);
			facesUtil.addInfo("Usuário salvo com sucesso!");
		} catch (Exception e) {
			facesUtil.addError(e.getMessage());
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
