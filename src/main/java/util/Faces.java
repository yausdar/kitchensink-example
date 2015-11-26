package util;

import java.util.Locale;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

@Stateless
public class Faces {

	public void addError(String msg) {
		addMessage(FacesMessage.SEVERITY_ERROR, msg);
	}

	public void addWarn(String msg) {
		addMessage(FacesMessage.SEVERITY_WARN, msg);
	}

	public void addInfo(String msg) {
		addMessage(FacesMessage.SEVERITY_INFO, msg);
	}

	private void addMessage(Severity severity, String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(severity, msg, null));
	}

	public void changeLocale(Locale locale) {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}
}
