package dao;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;
import model.ParamTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Param;

public class ParamDaoTest {

	private static EntityManagerFactory factory;
	private static EntityManager em;

	private static ParamDao dao;

	private static Param param;

	@BeforeClass
	public static void setUp() {
		factory = Persistence.createEntityManagerFactory("test");
		em = factory.createEntityManager();
		dao = new ParamDao(em);
	}

	@AfterClass
	public static void end() {
		em.close();
		factory.close();
	}

	@Before
	public void initScenario() {
		param = ParamTest.getParam();
		em.getTransaction().begin();
	}

	@After
	public void discardScenario() {
		em.getTransaction().rollback();
	}

	@Test
	public void save() {
		dao.save(param);
		Map<String, String> map = dao.getMap();
		Assert.assertEquals(param.getValor(), map.get(param.getChave()));
	}

	@Test
	public void remove() {
		int size = dao.getAll().size();
		dao.save(param);
		dao.remove(param);
		Assert.assertEquals(size, dao.getAll().size());
	}

	@Test
	public void getAll() {
		int size = dao.getAll().size();
		dao.save(param);
		Assert.assertEquals(size + 1, dao.getAll().size());
	}

	@Test
	public void getMap() {
		dao.save(param);
		Map<String, String> map = dao.getMap();
		Assert.assertEquals(param.getValor(), map.get(param.getChave()));
	}
}
