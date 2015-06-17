package beans;

import static util.UtilFunctions.*;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import objects.*;

@ManagedBean
@ViewScoped
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
		this.title = " " + navigationBean.getActivePage().getTitle();
    }
    
    // Actions ---------------------------------------------------------------------------------------------------------	
    
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
