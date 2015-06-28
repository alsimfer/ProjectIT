package beans;

import static util.UtilFunctions.*;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import objects.*;

@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {
 
	// Variables -------------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
	private Navigation navigation; 
	private String language;
	
	// Init ------------------------------------------------------------------------------------------------------------
	@PostConstruct
    public void init() {
		this.navigation = new Navigation();
    }
    
    // Getters/setters -------------------------------------------------------------------------------------------------
	public Navigation getNavigation() {
//		invalidateSession();
		return navigation;
	}

	public void setNavigation(Navigation navigation) {
		this.navigation = navigation;
	}
	
	public void setLanguage(String language) {
		if (language.length() > 0) {
			for (Page page: this.navigation.getNavigation()) {			
				page.setLanguage(language);			
			}
		}
	}

	public String getLanguage() {
		return language;
	}
}
