package service;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;

import java.util.ArrayList;

import model.UsuarioTest;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import dao.UsuarioDao;
import entity.Usuario;
import exception.BusinessRuleException;

@RunWith(EasyMockRunner.class)
public class UsuarioServiceTest {

	@TestSubject
	private final UsuarioService service = new UsuarioService();
	
	@Mock
	private UsuarioDao mock;

	private Usuario usuario;

	@Before
	public void setUp() {
		usuario = UsuarioTest.getUsuario();
	}

	@Test
	public void saveNewUsuario(){
		expect(mock.findByEmail(usuario.getEmail())).andReturn(null);
		mock.save(usuario);
		expectLastCall().once();
		replay(mock);
		service.saveUsuario(usuario);
	}
	
	@Test(expected = BusinessRuleException.class)
	public void saveUsuarioPasswordIncorrect(){
		usuario.setConfirmacaoSenha(null);
		service.saveUsuario(usuario);
	}
	
	@Test(expected = BusinessRuleException.class)
	public void saveRepeatedUsuario(){
		expect(mock.findByEmail(usuario.getEmail())).andReturn(usuario);
		replay(mock);
		service.saveUsuario(usuario);
	}
	
	@Test 
	public void saveAdmin(){
		expect(mock.findByEmail(usuario.getEmail())).andReturn(null);
		mock.save(usuario);
		expectLastCall().once();
		replay(mock);
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