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
public class ContentBean implements Serializable {
	
	// Variables -------------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
    private String content;
    	
	// Properties ------------------------------------------------------------------------------------------------------
	@ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean;
		
    // Init ------------------------------------------------------------------------------------------------------------
	@PostConstruct
    public void init() {
		this.content = navigationBean.getActivePage().getContent();
    }
    
    // Actions ---------------------------------------------------------------------------------------------------------	
    public void appendContent(String text) {
    	content += text;
    }
    
    // Getters/setters -------------------------------------------------------------------------------------------------    
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}
 
        
}
