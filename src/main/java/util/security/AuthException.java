package util.security;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class AuthException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4890701857391382516L;
	public static final String ACCESS_DENIED = "Acesso negado. O Usuário não possui permissão para executar esta ação.";
	public static final String AUTHENTICATION_ERROR = "Acesso negado. O Usuário deve fornecer suas credenciais antes de executar esta ação.";

	public AuthException(String msg){
		super(msg);
	}
	
	
}
