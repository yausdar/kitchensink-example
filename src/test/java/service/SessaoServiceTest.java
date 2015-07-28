package service;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import junit.framework.Assert;
import model.UsuarioTest;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import auth.AuthException;
import dao.UsuarioDao;
import entity.Usuario;

@RunWith(EasyMockRunner.class)
public class SessaoServiceTest {

	@TestSubject
	private final SessaoService service = new SessaoService();

	@Mock
	private UsuarioDao mock;

	private Usuario usuario;

	@Before
	public void setUp() {
		usuario = UsuarioTest.getUsuario();
	}

	@Test
	public void login() {
		String email = "email", senha = "senha";
		expect(mock.login(email, senha)).andReturn(usuario);
		replay(mock);
		service.login(email, senha);
		Assert.assertEquals(service.getUsuario(), usuario);
	}

	@Test(expected = AuthException.class)
	public void loginInvalid() {
		String email = "email", senha = "senha";
		expect(mock.login(email, senha)).andReturn(null);
		replay(mock);
		service.login(email, senha);
	}

	@Test
	public void logout(){
		String email = "email", senha = "senha";
		expect(mock.login(email, senha)).andReturn(usuario);
		replay(mock);
		service.login(email, senha);
		Assert.assertEquals(service.getUsuario(), usuario);
		service.logout();
		Assert.assertEquals(service.getUsuario(), null);		
	}
	
}
