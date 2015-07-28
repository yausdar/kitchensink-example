package rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import service.UsuarioService;
import entity.Usuario;

@Path("/usuario")
@RequestScoped
public class UsuarioRest {

	@EJB
	private UsuarioService usuarioService;

	@Path("/save")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario save(@QueryParam("nome") String nome,
			@QueryParam("email") String email,
			@QueryParam("senha") String senha,
			@QueryParam("confirmacaoSenha") String confirmacaoSenha) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setConfirmacaoSenha(confirmacaoSenha);
		usuarioService.saveUsuario(usuario);

		return usuario;
	}
	
	@Path("/foo")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario foo(){
		Usuario usuario = new Usuario();
		usuario.setNome("Foo");
		usuario.setEmail("foo@mail.com");
		return usuario;
	}

}
