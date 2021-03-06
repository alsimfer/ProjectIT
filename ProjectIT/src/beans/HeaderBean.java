package beans;

import static util.UtilFunctions.*;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import objects.*;

/**
 * Die Klasse HeaderBean repräsentiert die entsprechende Kopfzeile des Navigationspanels.
 *
 */

@ManagedBean
@SessionScoped
public class HeaderBean implements Serializable {
	// Variables -------------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;    
    private String title;
	    	
	// Properties ------------------------------------------------------------------------------------------------------
	@ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean;
		
    // Init ------------------------------------------------------------------------------------------------------------
	@PostConstruct
    public void init() {
		this.title = " Main";
    }
    
    // Getters/setters -------------------------------------------------------------------------------------------------        
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}
    
        
}
