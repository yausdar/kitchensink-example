package business.service;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;

import java.util.ArrayList;

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
import util.exception.BusinessRuleException;
import util.security.Role;

@RunWith(EasyMockRunner.class)
public class UsuarioServiceTest {

	@TestSubject
	private final UsuarioService service = new UsuarioService();
	
	@Mock
	private UsuarioDao mock;
	
	@Mock
	private SessaoService sessaoServiceMock;
	
	@Mock
	private Hash hashUtilMock;

	private Usuario usuario;

	@Before
	public void setUp() {
		usuario = UsuarioTest.getUsuario();
	}

	@Test
	public void saveNewUsuario(){
		expect(mock.findByEmail(usuario.getEmail())).andReturn(null);
		expect(sessaoServiceMock.isAdmin()).andReturn(false);
		expect(hashUtilMock.md5(usuario.getSenha())).andReturn("senha criptografada");
		mock.save(usuario);
		expectLastCall().once();
		replay(mock);
		replay(hashUtilMock);		
		replay(sessaoServiceMock);
		usuario.getListaPapel().add(Role.USER);
		service.save(usuario);
	}
	
	@Test(expected = BusinessRuleException.class)
	public void saveUsuarioPasswordIncorrect(){
		usuario.setConfirmacaoSenha(null);
		service.save(usuario);
	}
	
	@Test(expected = BusinessRuleException.class)
	public void saveRepeatedUsuario(){
		expect(mock.findByEmail(usuario.getEmail())).andReturn(usuario);
		replay(mock);
		service.save(usuario);
	}
	
	@Test 
	public void saveAdmin(){
		expect(mock.findByEmail(usuario.getEmail())).andReturn(null);
		expect(sessaoServiceMock.isAdmin()).andReturn(true);
		mock.save(usuario);
		expectLastCall().once();
		replay(mock);
		replay(sessaoServiceMock);
		usuario.getListaPapel().add(Role.ADMIN);
		service.saveAdmin(usuario);
	}
	
	@Test
	public void getAll(){
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		listaUsuario.add(usuario);
		expect(mock.getAll()).andReturn(listaUsuario);
		replay(mock);
		service.getAll();
	}
	
}