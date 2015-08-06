package bean;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import service.UsuarioService;
import util.Faces;
import entity.Usuario;

@Named
@RequestScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();

	private List<Usuario> listaUsuario = null;

	@EJB
	private UsuarioService usuarioService;

	public void saveUsuario() {
		try {
			usuarioService.saveUsuario(usuario);
			listaUsuario = null;
			Faces.addInfo("Usuário salvo com sucesso!");
		} catch (Exception e) {
			Faces.addError(e.getMessage());
		}
	}

	public void saveAdmin() {
		try {
			usuarioService.saveAdmin(usuario);
			listaUsuario = null;
			Faces.addInfo("Usuário salvo com sucesso!");
		} catch (Exception e) {
			Faces.addError(e.getMessage());
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			listaUsuario = usuarioService.getAll();
		}
		return this.listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

}
