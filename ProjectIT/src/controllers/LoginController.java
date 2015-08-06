package controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import beans.*;
import objects.*;
import daoimpl.UserDB;

/**
 * Klasse LoginController ist für das Anmelden, das Anpassen der Benutzerdaten und das Registrieren neuer Benutzer verantwortlich.
 *
 */

@ManagedBean
@ViewScoped
public class LoginController implements Serializable {	

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;	
	
	@ManagedProperty(value="#{contentBean}")
	private ContentBean contentBean;
	
	@ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean;
	
	private UserDB userDb;
	
	private boolean displaySignUpForm = false;
	
	public LoginController() {
    	super();
    }
	
	/**
	 * Aktualisierung der Benutzerdaten.
	 */
	public void updateUserProfileData() {
		userDb = getUserDB();
    	User user = userDb.getUserByEmail(loginBean.getActiveUser().getEmail());
    	
    	// updateRows ist 1, wenn das Aktualisieren erfolgreich war, sonst 0.
    	int updatedRows = userDb.updateUserById(user.getId(), loginBean.getActiveUser().getLastName(), loginBean.getActiveUser().getFirstName(), 
				loginBean.getActiveUser().getLanguage(), loginBean.getActiveUser().getPassword());
		if (updatedRows == 1) {
			contentBean.setContent(contentBean.getContent() + "\n" + "The data for user with email " + loginBean.getActiveUser().getEmail() + " was successfully changed.");
			
			// aktualisiere den aktiven Benutzer mit neuen Daten
			user = userDb.getUserByEmailPassword(loginBean.getActiveUser().getEmail(), loginBean.getActiveUser().getPassword());
			loginBean.setActiveUser(user);
			navigationBean.setLanguage(user.getLanguage());
		}    
    	
	}
	
	/**
	 * Regestrierung neues Benutzer.
	 */
	public void newUserSignUp() {
		// Check if the user exists (email / password). If so initialize stats, language and dictionary. Else create new user.
    	userDb = getUserDB();
    	User user = userDb.getUserByEmailPassword(loginBean.getActiveUser().getEmail(), loginBean.getActiveUser().getPassword());
    	
    	if (user != null) {
        	contentBean.setContent(contentBean.getContent() + "\n" + "The e-mail address " + loginBean.getActiveUser().getEmail() + " already exists!");      		      	
    	} else {   		
    		// else create new user.
    		int updatedRows = userDb.addUser(loginBean.getActiveUser().getLastName(), loginBean.getActiveUser().getFirstName(),
    				loginBean.getActiveUser().getEmail(), loginBean.getActiveUser().getPassword(), loginBean.getActiveUser().getLanguage());
    		if (updatedRows == 1) {
    			contentBean.setContent(contentBean.getContent() + "\n" + "New user was created. Welcome on our server, " + loginBean.getActiveUser().getFirstName());
    			user = userDb.getUserByEmailPassword(loginBean.getActiveUser().getEmail(), loginBean.getActiveUser().getPassword());
    			loginBean.setActiveUser(user);
    			navigationBean.setLanguage(user.getLanguage());
    			setDisplaySignUpForm(false);
    		}
    	}
	}
	
	/**
	 * Anmeldung eines Benutzers.
	 */
	public void login() {
    	// Check if the user exists (email / password). If so initialize stats, language and dictionary. Else create new user.
    	userDb = getUserDB();
    	User user = userDb.getUserByEmailPassword(loginBean.getActiveUser().getEmail(), loginBean.getActiveUser().getPassword());

    	// If found - put new first name, last name and language setups for this user if needed.
    	if (user != null) {
    		contentBean.setContent(contentBean.getContent() + "\n" + "Nice to see you again, " + user.getFirstName());   			
    		loginBean.setActiveUser(user);
    		navigationBean.setLanguage(user.getLanguage());
    	} else {   		
    		contentBean.setContent(contentBean.getContent() + "\n" + "The password or e-mail is incorrect! Please try again.");
    	}
    	
    }
    
    public String refreshPage() {
    	return "login.xhtml";
    }

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public ContentBean getContentBean() {
		return contentBean;
	}

	public void setContentBean(ContentBean contentBean) {
		this.contentBean = contentBean;
	}
	
	public UserDB getUserDB() {
		if(userDb == null) {
			userDb = new UserDB();
		}
		return userDb;
	}

	public boolean isDisplaySignUpForm() {
		return displaySignUpForm;
	}

	public void setDisplaySignUpForm(boolean displaySignUpForm) {
		this.displaySignUpForm = displaySignUpForm;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}
    
}
