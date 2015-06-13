package beans;

import static util.UtilFunctions.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import objects.*;

@ManagedBean
@SessionScoped

public class LanguageBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
    
	private String language;
	private HashMap<String, String> languageSelect = new HashMap<String, String>();

    public LanguageBean() {
    	// label, value.
        this.languageSelect.put("<img src=\"resources/images/england.png\""
        		+ " alt=\"england\" width=\"24\" height=\"16\"> English", "english");
        this.languageSelect.put("<img src=\"resources/images/germany.png\""
        		+ " alt=\"deutschland\" width=\"24\" height=\"16\"> Deutsch", "german");
        this.languageSelect.put("<img src=\"resources/images/russia.png\""
        		+ " alt=\"russia\" width=\"24\" height=\"16\"> Русский", "russian");
    }
    
    public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public HashMap<String, String> getLanguageSelect() {
		return languageSelect;
	}

	public void setLanguageSelect(HashMap<String, String> languageSelect) {
		this.languageSelect = languageSelect;
	}

}
