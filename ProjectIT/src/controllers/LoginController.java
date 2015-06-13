package controllers;

import static util.UtilFunctions.*;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import beans.*;
import objects.*;
import db.*;

@ManagedBean
@SessionScoped

public class LoginController extends Controller {	
    
	private static final long serialVersionUID = 1L;
	
	DBQuery query;
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;	
	
	@ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean;	
	
	@ManagedProperty(value="#{contentBean}")
	private ContentBean contentBean;
	
	public LoginController() {
    	super();
    	query = new DBQuery();
    }

    public void getClickResult() {
    	// Check if the user exists (email / password). If so initialize stats, language and dictionary. Else create new user.
    	String firstName = loginBean.getFirstName();
    	String lastname = loginBean.getLastName();
    	String email = loginBean.getEmail();
    	String password = loginBean.getPassword();
    	String language = navigationBean.getLanguage();
    	User user = query.getUserByEmailPassword(email, password);

    	if (user != null) {
        	query.closeConnection();
    		// If user was found we need to reload the page with the user language, dictionary and stats.
    	} else {   		
    		// else create new user.
    		int updatedRows = query.addUser(lastname, firstName, email, password, language);
    		query.closeConnection();
    		if (updatedRows == 1) {
    			contentBean.setContent("Welcome, you are signed up under " + email);
    		}
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

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public ContentBean getContentBean() {
		return contentBean;
	}

	public void setContentBean(ContentBean contentBean) {
		this.contentBean = contentBean;
	}
    
}
