package business.service;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import junit.framework.Assert;
import model.dao.UsuarioDao;
import model.entity.Usuario;
import model.entity.UsuarioTest;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import util.Hash;
import util.security.AuthException;

@RunWith(EasyMockRunner.class)
public class SessaoServiceTest {

	@TestSubject
	private final SessaoService service = new SessaoService();

	@Mock
	private UsuarioDao mock;

	@Mock
	private Hash hashUtilMock;
	
	private Usuario usuario;

	@Before
	public void setUp() {
		usuario = UsuarioTest.getUsuario();
	}

	@Test
	public void login() {
		expect(mock.login(usuario)).andReturn(usuario);
		expect(hashUtilMock.md5(usuario.getSenha())).andReturn("senha criptografada");
		replay(mock);
		service.login(usuario);
		Assert.assertEquals(service.getUsuario(), usuario);
	}

	@Test(expected = AuthException.class)
	public void loginInvalid() {
		expect(mock.login(usuario)).andReturn(null);
		replay(mock);
		service.login(usuario);
	}

	@Test
	public void logout(){
		expect(mock.login(usuario)).andReturn(usuario);
		replay(mock);
		service.login(usuario);
		Assert.assertEquals(service.getUsuario(), usuario);
		service.logout();
		Assert.assertEquals(service.getUsuario(), null);		
	}
	
}
