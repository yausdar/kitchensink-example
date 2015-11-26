package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;
import model.entity.Usuario;
import model.entity.UsuarioTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	public void save() {
		dao.save(usuario);
		Usuario resultado = dao.findByEmail(usuario.getEmail());
		Assert.assertNotNull(resultado);
		Assert.assertEquals(usuario.getNome(), resultado.getNome());
	}

	@Test
	public void getAll() {
		int size = dao.getAll().size();
		dao.save(usuario);
		Assert.assertEquals(size + 1, dao.getAll().size());
	}

	@Test
	public void findByEmail() {
		dao.save(usuario);
		Assert.assertNotNull(dao.findByEmail(usuario.getEmail()));
		Assert.assertNull(dao.findByEmail("email"));
	}

	@Test
	public void findByEmailInvalid() {
		Assert.assertNull(dao.findByEmail(null));
		Assert.assertNull(dao.findByEmail(""));
	}

	@Test
	public void loginNull() {
		dao.save(usuario);
		Assert.assertNull(dao.login(new Usuario(null, "senha")));
		Assert.assertNull(dao.login(new Usuario("email", null)));
		Assert.assertNull(dao.login(new Usuario(null, null)));
		Assert.assertNull(dao.login(new Usuario(usuario.getEmail(), "senha")));
		Assert.assertNull(dao.login(new Usuario("email", usuario.getSenha())));

	}
}
