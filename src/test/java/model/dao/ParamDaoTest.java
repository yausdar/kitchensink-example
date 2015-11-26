package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;
import model.entity.Param;
import model.entity.ParamTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		List<Param> listaParam = dao.getListaParam();
		dao.save(param);
		Assert.assertEquals(listaParam.size() + 1, dao.getListaParam().size());
	}

	@Test
	public void remove() {
		List<Param> listaParam = dao.getListaParam();
		dao.save(param);
		dao.remove(param);
		Assert.assertEquals(listaParam.size(), dao.getListaParam().size());
	}

	@Test
	public void getAll() {
		List<Param> listaParam = dao.getListaParam();
		dao.save(param);
		Assert.assertEquals(listaParam.size() + 1, dao.getListaParam().size());
	}
}
