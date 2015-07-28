package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;
import model.UsuarioTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Usuario;

public class UsuarioDaoTest {

	private static EntityManagerFactory factory;
	private static EntityManager em;

	private static UsuarioDao dao;

	private static Usuario usuario;

	@BeforeClass
	public static void setup() {
		factory = Persistence.createEntityManagerFactory("test");
		em = factory.createEntityManager();
		dao = new UsuarioDao(em);
	}

	@AfterClass
	public static void end() {
		em.close();
		factory.close();
	}

	@Before
	public void initScenario() {
		usuario = UsuarioTest.getUsuario();
		em.getTransaction().begin();
	}

	@After
	public void discardScenario() {
		em.getTransaction().rollback();
	}
	
	@Test
	public void save(){
		dao.save(usuario);
		Usuario foundByEmail = dao.findByEmail(usuario.getEmail());
		Assert.assertNotNull(foundByEmail);
		Assert.assertEquals(usuario.getNome(), foundByEmail.getNome());
	}
	
	@Test
	public void getAll(){
		int size = dao.getAll().size();
		dao.save(usuario);
		Assert.assertEquals(size+1, dao.getAll().size());
	}
	
	@Test
	public void findByEmail(){
		dao.save(usuario);
		Assert.assertNotNull(dao.findByEmail(usuario.getEmail()));
		Assert.assertNull(dao.findByEmail("email"));
	}
	
	@Test
	public void findByEmailInvalid(){
		Assert.assertNull(dao.findByEmail(null));
		Assert.assertNull(dao.findByEmail(""));
	}
	
	@Test
	public void loginNull(){
		dao.save(usuario);
		Assert.assertNull(dao.login(null, "senha"));
		Assert.assertNull(dao.login("email", null));
		Assert.assertNull(dao.login(null, null));
		Assert.assertNull(dao.login(usuario.getEmail(), "senha"));
		Assert.assertNull(dao.login("email", usuario.getSenha()));
		Assert.assertEquals(usuario.getNome(), dao.login(UsuarioTest.getUsuario().getEmail(), UsuarioTest.getUsuario().getSenha()).getNome());
		
	}
}
