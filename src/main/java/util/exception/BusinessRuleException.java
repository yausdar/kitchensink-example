package util.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BusinessRuleException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4187239215184770819L;

	public BusinessRuleException(String message){
		super(message);
	}
	
}
