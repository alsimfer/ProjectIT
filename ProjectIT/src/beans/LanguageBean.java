package beans;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Die Klasse LanguageBean ist für die Internatialisierung zuständig.
 *
 */

@ManagedBean
@SessionScoped
public class LanguageBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
    
	private Locale locale;

    @PostConstruct
    public void init() {
    	if(locale == null) {
    		locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
    	}
    }

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
    	switch(language) {
    	case "english": locale = new Locale("en"); break;
    	case "german": locale = new Locale("de"); break;
    	case "russian": locale = new Locale("ru"); break;
    		default : locale = new Locale("en"); break;
    	}        
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
}
