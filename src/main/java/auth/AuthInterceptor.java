package auth;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import entity.Usuario;
import bean.SessaoBean;

public class AuthInterceptor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4846004993225522111L;

	@Inject
	private SessaoBean sessaoBean;

	@AroundInvoke
	public Object interceptor(InvocationContext ic) throws Exception {

		RolesAllowed rolesAllowed = ic.getMethod().getAnnotation(
				RolesAllowed.class);

		if (rolesAllowed == null) {
			return ic.proceed();
		}

		Usuario user = sessaoBean.getUsuario();

		if (user == null) {
			throw new AuthException(AuthException.AUTHENTICATION_ERROR);
		}

		List<Role> listRole = user.getListaPapel();
		
		if(listRole == null || listRole.isEmpty()){
			throw new AuthException(AuthException.ACCESS_DENIED);
		}

		if (!isAllowed(listRole,
				Arrays.asList(rolesAllowed.value()))) {
			throw new AuthException(AuthException.ACCESS_DENIED);
		}

		return ic.proceed();

	}

	public boolean isAllowed(List<Role> listUserRoles,
			List<Role> listRolesAllowed) {
		for (Role role : listUserRoles) {
			if (listRolesAllowed.contains(role)) {
				return true;
			}

		}

		return false;
	}

}
