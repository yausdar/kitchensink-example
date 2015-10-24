package service;

import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import auth.Role;
import auth.RolesAllowed;
import dao.ParamDao;
import entity.Param;

@Stateful
public class ParamService {

	@EJB
	private ParamDao paramDao;

	private Map<String, Param> params;

	@RolesAllowed(Role.ADMIN)
	public Map<String, Param> getMap() {
		if (params == null) {
			params = paramDao.getMap();
		}
		return paramDao.getMap();
	}

	@RolesAllowed(Role.ADMIN)
	public void save(Param param) {
		paramDao.save(param);
	}

	@RolesAllowed(Role.ADMIN)
	public void remove(Param param) {
		paramDao.remove(param);
	}

}
