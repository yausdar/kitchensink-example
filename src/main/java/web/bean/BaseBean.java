package web.bean;

import java.io.Serializable;

import javax.ejb.EJB;

import util.Faces;

public abstract class BaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 76981657750192906L;

	@EJB
	protected Faces facesUtil;
	
	
}
