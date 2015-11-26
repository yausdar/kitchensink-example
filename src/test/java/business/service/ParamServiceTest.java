package business.service;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;
import model.dao.ParamDao;
import model.entity.Param;
import model.entity.ParamTest;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class ParamServiceTest {

	@TestSubject
	private final ParamService service = new ParamService();

	@Mock
	private ParamDao mock;

	private Param param;

	@Before
	public void setUp() {
		param = ParamTest.getParam();
	}

	@Test
	public void getParam(){
		ArrayList<Param> listaParam = new ArrayList<Param>();
		listaParam.add(param);
		expect(mock.getListaParam()).andReturn(listaParam);
		replay(mock);
		Param paramResultado = service.getParam(param.getChave());
		Assert.assertEquals(param, paramResultado);
	}
	
	@Test
	public void getMap() {
		ArrayList<Param> listaParam = new ArrayList<Param>();
		listaParam.add(param);
		expect(mock.getListaParam()).andReturn(listaParam);
		replay(mock);
		Map<String, Param> map = service.getMap();
		Assert.assertEquals(listaParam.size(), map.values().size());
		Assert.assertEquals(param, map.get(param.getChave()));
	}

	@Test
	public void getListaParam() {
		ArrayList<Param> listaParam = new ArrayList<Param>();
		listaParam.add(param);
		expect(mock.getListaParam()).andReturn(listaParam);
		replay(mock);
		List<Param> listaResultado = service.getListaParam();
		Assert.assertEquals(listaParam.size(), listaResultado.size());
		Assert.assertEquals(param, listaResultado.get(0));
	}

	@Test
	public void save() {
		mock.save(param);
		expectLastCall().once();
		replay(mock);
		service.save(param);
	}

	@Test
	public void remove() {
		mock.remove(param);
		expectLastCall().once();
		replay(mock);
		service.remove(param);
	}
}
