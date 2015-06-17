package beans;

import static util.UtilFunctions.invalidateSession;
import static util.UtilFunctions.p;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;

import objects.*;

@ManagedBean
//@ApplicationScoped
@SessionScoped
public class ActiveUserBean implements Serializable {

	// Variables -------------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
	private User activeUser;
    
	// Properties ------------------------------------------------------------------------------------------------------

    // Init ------------------------------------------------------------------------------------------------------------	
	@PostConstruct
	public void init() {
		activeUser = new User();
	}
	
	// Actions ---------------------------------------------------------------------------------------------------------	
    public String logout() {
    	activeUser = new User();
    	return "main.xhtml";
    }

	public User getActiveUser() {
		// Check if activeUser was not instantiated because of some error and saved in this state in the session.
		if (activeUser == null) {
			invalidateSession();
			activeUser = new User();
		}
		
		return activeUser;
	}

	public void setActiveUser(User activeUser) {
		this.activeUser = activeUser;
	}

}