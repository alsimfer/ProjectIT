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
	private ArrayList<Page> navigation; 
	
	// Init ------------------------------------------------------------------------------------------------------------
	@PostConstruct
    public void init() {
		Navigation nav = new Navigation();
		this.navigation = nav.getNavigation();
    }
    
    // Getters/setters -------------------------------------------------------------------------------------------------
	public ArrayList<Page> getNavigation() {
//		invalidateSession();
		return navigation;
	}

	public void setNavigation(ArrayList<Page> navigation) {
		this.navigation = navigation;
	}
}
