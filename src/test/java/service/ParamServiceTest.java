package service;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;
import model.ParamTest;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import dao.ParamDao;
import entity.Param;

@RunWith(EasyMockRunner.class)
public class ParamServiceTest {

	@TestSubject
	private final ParamService service = new ParamService();
	
	@Mock
	private ParamDao mock;
	
	private Param param;
	
	@Before
	public void setUp(){
		param = ParamTest.getParam();
	}
	
	@Test
	public void getAll(){
		ArrayList<Param> listaEsperada = new ArrayList<Param>();
		listaEsperada.add(param);
		expect(mock.getAll()).andReturn(listaEsperada);
		replay(mock);
		List<Param> listaResultado = service.getAll();
		Assert.assertEquals(listaEsperada.size(), listaResultado.size());
		Assert.assertEquals(listaEsperada.get(0), listaResultado.get(0));
	}
	
	@Test
	public void getMap(){
		HashMap<String, String> mapEsperado = new HashMap<String,String>();
		mapEsperado.put(param.getChave() , param.getValor());
		expect(mock.getMap()).andReturn(mapEsperado);
		replay(mock);
		Map<String, String> mapResultado = service.getMap();		
		Assert.assertEquals(mapEsperado.size(), mapResultado.size());
		Assert.assertEquals(mapEsperado.get(param.getChave()), mapResultado.get(param.getChave()));
	}
	
	@Test
	public void save(){
		mock.save(param);
		expectLastCall().once();
		replay(mock);
		service.save(param);
	}
	
	@Test
	public void remove(){
		mock.remove(param);
		expectLastCall().once();
		replay(mock);
		service.remove(param);
	}
}
