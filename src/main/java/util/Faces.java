package util;

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Faces {

	public static void addError(String msg) {
		addMessage(FacesMessage.SEVERITY_ERROR, msg);
	}

	public static void addWarn(String msg) {
		addMessage(FacesMessage.SEVERITY_WARN, msg);
	}

	public static void addInfo(String msg) {
		addMessage(FacesMessage.SEVERITY_INFO, msg);
	}

	private static void addMessage(Severity severity, String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(severity, msg, null));
	}

	public static void changeLocale(Locale locale) {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}
}
