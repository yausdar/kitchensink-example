package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import util.Faces;

@SessionScoped
@Named
public class LocaleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3154800074528366128L;

	private List<String> listLocale;
	
	private String locale;

	@PostConstruct
	public void init() {
		locale = "en";
		
		listLocale = new ArrayList<String>();
		listLocale.add("en");
		listLocale.add("pt");
		listLocale.add("it");
	}

	public void changeLocale(){
		Faces.changeLocale(new Locale(locale));
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public List<String> getListLocale() {
		return listLocale;
	}

	public void setListLocale(List<String> listLocale) {
		this.listLocale = listLocale;
	}

	
	
	

}
