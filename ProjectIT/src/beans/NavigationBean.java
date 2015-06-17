package beans;

import static util.UtilFunctions.*;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import objects.*;

@ManagedBean
@ViewScoped
public class NavigationBean implements Serializable {
 
	// Variables -------------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
	private ArrayList<Page> navigation; 
	private Page activePage;
    private String language;
    
	// Properties ------------------------------------------------------------------------------------------------------
	@ManagedProperty("#{activeUserBean}")
    private ActiveUserBean activeUserBean;
	
    // Init ------------------------------------------------------------------------------------------------------------
	@PostConstruct
    public void init() {
		// FIXME: this should be done with the class which extends AL itself. 
		Navigation nav = new Navigation();
		navigation = nav.getNavigation();
		
		// Translate all pages depending on user language preferences.
		if (activeUserBean.getActiveUser().getId() > 0) {
			this.language = activeUserBean.getActiveUser().getLanguage();		
			// Set the users language on all pages.
			for (Page page: navigation) {				
				page.setLanguage(this.language);				
			}
		}    
		
		// Set active page to get the correct references on title and content.
		String slug = getCurrentSlug();
		if (slug.length() == 0) {
			this.activePage = navigation.get(0);
		} else {
			for (Page page: navigation) {						
				if (page.getSlug().equals(slug)) {
					this.activePage = page;
				}
			}
		}
				
    }
    
    // Actions ---------------------------------------------------------------------------------------------------------	
    public String setActivePage(Page page) {
    	this.activePage = page;
    	return page.getSlug();
    }
    
    public String reload() {
    	return "main.xhtml?faces-redirect=true";
    }
    
    // Getters/setters -------------------------------------------------------------------------------------------------
	public ArrayList<Page> getNavigation() {
		return navigation;
	}

	public void setNavigation(ArrayList<Page> navigation) {
		this.navigation = navigation;
	}    
        
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public ActiveUserBean getActiveUserBean() {
		return activeUserBean;
	}

	public void setActiveUserBean(ActiveUserBean activeUserBean) {
		this.activeUserBean = activeUserBean;
	}

	public Page getActivePage() {
		return activePage;
	}

}
