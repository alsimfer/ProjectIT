package beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import objects.*;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
	
	// Variables -------------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
    private User activeUser;
	
    // Init ------------------------------------------------------------------------------------------------------------
    @PostConstruct
    public void init() {
    	activeUser = new User();
    }
    
    // Getters/setters -------------------------------------------------------------------------------------------------
	public User getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(User activeUser) {
		this.activeUser = activeUser;
	}
    
}
