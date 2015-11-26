package model.entity;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import model.entity.Usuario;

import org.junit.Before;
import org.junit.Test;

import util.Util;
import util.security.Role;

public class UsuarioTest {

	private static Usuario usuario;
	private Validator validator;

	public static Usuario getUsuario(){
		Usuario usuario = new Usuario();
		usuario.setNome(Util.getStringWithSize(255));
		usuario.setEmail("email@mail.com");
		usuario.setSenha("senha123");
		usuario.setConfirmacaoSenha(usuario.getSenha());
		usuario.setListaPapel(new ArrayList<Role>());
		return usuario;
	}
	
	@Before
	public void setUp() {
		usuario = getUsuario();
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void usuarioIsValid() {
		Set<ConstraintViolation<Usuario>> errors = validator.validate(usuario);
		assertEquals(0, errors.size());
	}
	
	@Test
	public void nomeIsNull(){
		usuario.setNome(null);
		Set<ConstraintViolation<Usuario>> errors = validator.validate(usuario);
		assertEquals(1, errors.size());
		assertEquals("O campo NOME COMPLETO é obrigatório", errors.iterator().next().getMessage());
	}
	
	@Test
	public void nomeIsTooSmall(){
		usuario.setNome(Util.getStringWithSize(9));
		Set<ConstraintViolation<Usuario>> errors = validator.validate(usuario);
		assertEquals(1, errors.size());
		assertEquals("O campo NOME COMPLETO deve ter entre 10 e 255 caracteres", errors.iterator().next().getMessage());
	}
	
	@Test
	public void nomeIsTooBig(){
		usuario.setNome(Util.getStringWithSize(256));
		Set<ConstraintViolation<Usuario>> errors = validator.validate(usuario);
		assertEquals(1, errors.size());
		assertEquals("O campo NOME COMPLETO deve ter entre 10 e 255 caracteres", errors.iterator().next().getMessage());
	}
	
	@Test
	public void emailIsNull(){
		usuario.setEmail(null);
		Set<ConstraintViolation<Usuario>> errors = validator.validate(usuario);
		assertEquals(1, errors.size());
		assertEquals("O campo EMAIl é obrigatório", errors.iterator().next().getMessage());
	}
	
	@Test
	public void emailIsInvalid(){
		usuario.setEmail("testnado");
		Set<ConstraintViolation<Usuario>> errors = validator.validate(usuario);
		assertEquals(1, errors.size());
		assertEquals("O campo EMAIL não possui um formato válido", errors.iterator().next().getMessage());
	}
	
	@Test
	public void senhaIsNull(){
		usuario.setSenha(null);
		Set<ConstraintViolation<Usuario>> errors = validator.validate(usuario);
		assertEquals(1, errors.size());
		assertEquals("O campo SENHA é obrigatório", errors.iterator().next().getMessage());
	}
	
	@Test
	public void senhaIsTooBig(){
		usuario.setSenha(Util.getStringWithSize(41));
		Set<ConstraintViolation<Usuario>> errors = validator.validate(usuario);
		assertEquals(1, errors.size());
		assertEquals("O campo SENHA deve ter entre 8 e 40 caracteres", errors.iterator().next().getMessage());
	}
	
}
