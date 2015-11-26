package business.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import model.dao.ParamDao;
import model.entity.Param;

@Stateful
public class ParamService {

	@EJB
	private ParamDao paramDao;

	private List<Param> listaParam;

	public Param getParam(String chave) {
		return getMap().get(chave);
	}

	protected Map<String, Param> getMap() {
		HashMap<String, Param> map = new HashMap<String, Param>();
		for (Param p : getListaParam()) {
			map.put(p.getChave(), p);
		}
		return map;
	}

	public List<Param> getListaParam() {
		if (listaParam == null) {
			listaParam = paramDao.getListaParam();
		}
		return listaParam;
	}

	public void save(Param param) {
		paramDao.save(param);
		listaParam = null;
	}

	public void remove(Param param) {
		paramDao.remove(param);
		listaParam = null;
	}

}
