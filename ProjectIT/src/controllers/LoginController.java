package controllers;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.*;

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
	
	final String baseName = "languageProperties.Language";
	// Keys in Language_xx.properties
	final String lg_key_userDataIsChangedSuccessful = "login_message_userDataIsChangedSuccessful";
	final String lg_key_emailAlreadyExists = "login_message_emailAlreadyExists";
	final String lg_key_newUserCreated = "login_message_newUserCreated";
	final String lg_key_niceToSeeYouAgain = "login_message_niceToSeeYouAgain";
	final String lg_key_passwortOrMailIncorrect = "login_message_passwortOrMailIncorrect";

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
			// aktualisiere den aktiven Benutzer mit neuen Daten
			user = userDb.getUserByEmailPassword(loginBean.getActiveUser().getEmail(), loginBean.getActiveUser().getPassword());
			loginBean.setActiveUser(user);
			navigationBean.setLanguage(user.getLanguage());
			
			// Internalisation der Meldungen
			String message = ResourceBundle.getBundle(baseName, loginBean.getLanguageBean().getLocale()).getString(lg_key_userDataIsChangedSuccessful);
			contentBean.setContent(message);
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
    		// Internalisation der Meldungen
    		String message = ResourceBundle.getBundle(baseName, loginBean.getLanguageBean().getLocale()).getString(lg_key_emailAlreadyExists);
        	contentBean.setContent(message);      		      	
    	} else {   		
    		// else create new user.
    		int updatedRows = userDb.addUser(loginBean.getActiveUser().getLastName(), loginBean.getActiveUser().getFirstName(),
    				loginBean.getActiveUser().getEmail(), loginBean.getActiveUser().getPassword(), loginBean.getActiveUser().getLanguage());
    		if (updatedRows == 1) {
    			user = userDb.getUserByEmailPassword(loginBean.getActiveUser().getEmail(), loginBean.getActiveUser().getPassword());
    			loginBean.setActiveUser(user);
    			navigationBean.setLanguage(user.getLanguage());
    			
    			// Internalisation der Meldungen
    			String message = ResourceBundle.getBundle(baseName, loginBean.getLanguageBean().getLocale()).getString(lg_key_newUserCreated);
    			contentBean.setContent(message + loginBean.getActiveUser().getFirstName());
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
    		loginBean.setActiveUser(user);
    		navigationBean.setLanguage(user.getLanguage());
    		
    		// Internalisation der Meldungen
    		String message = ResourceBundle.getBundle(baseName, loginBean.getLanguageBean().getLocale()).getString(lg_key_niceToSeeYouAgain);
    		contentBean.setContent(message + user.getFirstName());   			
    	} else {   
    		String message = ResourceBundle.getBundle(baseName, loginBean.getLanguageBean().getLocale()).getString(lg_key_passwortOrMailIncorrect);
    		contentBean.setContent(message);
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
