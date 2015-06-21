package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import beans.*;
import objects.*;
import daoimpl.UserDB;

@ManagedBean
@RequestScoped
public class LoginController{	
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;	
	
	@ManagedProperty(value="#{contentBean}")
	private ContentBean contentBean;
	
	private UserDB userDb;
	
	public LoginController() {
    	super();
    }
	
	public void login() {
    	// Check if the user exists (email / password). If so initialize stats, language and dictionary. Else create new user.
    	userDb = getUserDB();
    	User user = userDb.getUserByEmailPassword(loginBean.getActiveUser().getEmail(), loginBean.getActiveUser().getPassword());

    	// If found - put new first name, last name and language setups for this user if needed.
    	if (user != null) {
    		if (user.getFirstName().equals(loginBean.getActiveUser().getFirstName()) 
				&& user.getLastName().equals(loginBean.getActiveUser().getLastName()) 
				&& user.getLanguage().equals(loginBean.getActiveUser().getLanguage())
			) {
    			contentBean.setContent("Nice to see you again, " + loginBean.getActiveUser().getFirstName());
    		} else {
    			int updatedRows = userDb.updateUserById(user.getId(), loginBean.getActiveUser().getLastName(), loginBean.getActiveUser().getFirstName(), 
    					loginBean.getActiveUser().getLanguage());
        		if (updatedRows == 1) {
        			contentBean.setContent("The data for user with email " + loginBean.getActiveUser().getEmail() + " was successfully changed.");
        		}        		
    		}      	
    	} else {   		
    		// else create new user.
    		int updatedRows = userDb.addUser(loginBean.getActiveUser().getLastName(), loginBean.getActiveUser().getFirstName(),
    				loginBean.getActiveUser().getEmail(), loginBean.getActiveUser().getPassword(), loginBean.getActiveUser().getLanguage());
    		if (updatedRows == 1) {
    			contentBean.setContent("New user was created. Welcome on our server, " + loginBean.getActiveUser().getFirstName());
    		}
    	}
    	
		user = userDb.getUserByEmailPassword(loginBean.getActiveUser().getEmail(), loginBean.getActiveUser().getPassword());
    	loginBean.setActiveUser(user);
    }
	
	public String logout() {
		contentBean.init();
    	loginBean.setActiveUser(new User());
    	return "main.xhtml";
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
    
}
