package beans;

import static util.UtilFunctions.*;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;

import db.DBQuery;
import objects.*;

@ManagedBean
@ViewScoped
/**
 * This is a controller for login form.
 * @author Alex
 */
public class LoginBean implements Serializable {
	
	// Variables -------------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
    private String firstName, lastName, email, password, language, topMessage;
    
	// Properties ------------------------------------------------------------------------------------------------------
    @ManagedProperty("#{activeUserBean}")
    private ActiveUserBean activeUserBean;
    
    @ManagedProperty("#{contentBean}")
    private ContentBean contentBean;
	
    // Init ------------------------------------------------------------------------------------------------------------
    @PostConstruct
    public void init() {
    	firstName = activeUserBean.getActiveUser().getFirstName();
    	lastName = activeUserBean.getActiveUser().getLastName();
    	email = activeUserBean.getActiveUser().getEmail();
    	language = activeUserBean.getActiveUser().getLanguage();
    	password = activeUserBean.getActiveUser().getPassword();
    }
    

    // Actions ---------------------------------------------------------------------------------------------------------	
    public String login() {
    	// Check if the user exists (email / password). If so initialize stats, language and dictionary. Else create new user.
    	DBQuery query = new DBQuery();
    	User user = query.getUserByEmailPassword(email, password);

    	// If found - put new first name, last name and language setups for this user if needed.
    	if (user != null) {
    		if (user.getFirstName().equals(firstName) 
				&& user.getLastName().equals(lastName) 
				&& user.getLanguage().equals(language)
			) {
    			topMessage = "Nice to see you again, " + firstName;
    		} else {
    			int updatedRows = query.updateUserById(user.getId(), lastName, firstName, language);
        		if (updatedRows == 1) {
        			topMessage = "The data for user with email " + email + " was successfully changed.";
        		}        		
    		}      	
    	} else {   		
    		// else create new user.
    		int updatedRows = query.addUser(lastName, firstName, email, password, language);
    		if (updatedRows == 1) {
    			topMessage = "New user was created. Welcome on our server, " + firstName;
    		}
    	}
    	
		user = query.getUserByEmailPassword(email, password);
    	activeUserBean.setActiveUser(user);
		query.closeConnection();
    	return "login.xhtml";
    }
    
    // Getters/setters -------------------------------------------------------------------------------------------------
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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


	public ContentBean getContentBean() {
		return contentBean;
	}


	public void setContentBean(ContentBean contentBean) {
		this.contentBean = contentBean;
	}


	public String getTopMessage() {
		return topMessage;
	}


	public void setTopMessage(String topMessage) {
		this.topMessage = topMessage;
	}
    
}
