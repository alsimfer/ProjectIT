package controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;

import objects.*;
import beans.*;

/**
 * Klasse NavigationController ist für die Navigation zwischen verschiedenen Seiten verantwortlich.
 *
 */

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String language;
	
	// Properties ------------------------------------------------------------------------------------------------------
	@ManagedProperty(value="#{headerBean}")
	private HeaderBean headerBean;
	@ManagedProperty(value="#{contentBean}")
	private ContentBean contentBean;
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	@ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean;
	
	// This managed property will read value from request parameter pageId.
	@ManagedProperty(value = "#{param.pageId}")
	private String pageId;
	
	@PostConstruct
	public void init() {
		// Translate all pages depending on user language preferences.
		if (loginBean.getActiveUser().getId() > 0) {
			this.language = loginBean.getActiveUser().getLanguage();
		} else {
			this.language = "english";
		}
		navigationBean.setLanguage(language);
	}
	
	/**
	 * Gibt den Pfad von der erwarteten Seite zurück.
	 * 
	 */
	public String showPage() {
		if (pageId == null) {
			String returnString = this.moveToMain("");
			return returnString;
		}
		if (pageId.equals("1")) {
			return this.moveToMain("");
		} else if (pageId.equals("2")) {
			return this.moveToDictionary("");
		} else if (pageId.equals("3")) {
			return this.moveToTest("");
		} else {
			return this.moveToLogin("");
		}
	}
	
	/**
	 * Gibt den Pfad von der main-Seite zurück.
	 * 
	 */
	public String moveToMain(String extra) {
    	Page page = navigationBean.getNavigation().getPageById(1);
    	headerBean.setTitle(" " + page.getTitle());
//    	navigationBean.setNavigation(this.navigation.getNavigation());
    	String content = page.getContent();
    	content += "<br />" + extra;
    	contentBean.setContent(content);
    	return page.getSlug() + "?faces-redirect=true";
    }
    
	/**
	 * Gibt den Pfad von der Wörterbuch-Seite zurück.
	 * 
	 */
    public String moveToDictionary(String extra) {
    	Page page = navigationBean.getNavigation().getPageById(2);
    	headerBean.setTitle(" " + page.getTitle());
    	String content = page.getContent();
    	content += "<br />" + extra;
    	contentBean.setContent(content);
    	return page.getSlug() + "?faces-redirect=true";
    }
    
    /**
	 * Gibt den Pfad von der Test-Seite zurück.
	 * 
	 */
    public String moveToTest(String extra) {
    	Page page = navigationBean.getNavigation().getPageById(3);
    	headerBean.setTitle(" " + page.getTitle());
    	String content = page.getContent();
    	content += extra;
    	contentBean.setContent(content);
    	return page.getSlug() + "?faces-redirect=true";
    }
    
    /**
	 * Gibt den Pfad von der Login-Seite zurück.
	 * 
	 */
    public String moveToLogin(String extra) {
    	Page page = navigationBean.getNavigation().getPageById(4);
    	headerBean.setTitle(" " + page.getTitle());
    	String content = page.getContent();
    	content += extra;
    	contentBean.setContent(content);
    	return page.getSlug() + "?faces-redirect=true";
    }
    
    /**
	 * Gibt den Pfad für die Durchführung des Tests zurück.
	 * 
	 */
    public String startTest() {
    	Page page = navigationBean.getNavigation().getPageById(3);
    	headerBean.setTitle(" " + page.getTitle());
    	contentBean.setContent(page.getContent());
		return "testPage.xhtml?faces-redirect=true";
    }
    
    /**
	 * Gibt den Pfad von der Login-Seite beim Abmelden zurück.
	 * 
	 */
    public String logout() {
    	navigationBean.setLanguage("english");
    	Page page = navigationBean.getNavigation().getPageById(4);
    	headerBean.setTitle(" " + page.getTitle());
    	String content = page.getContent();
    	contentBean.setContent(content);
    	loginBean.setActiveUser(new User());
    	return "login.xhtml";
    }

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public ContentBean getContentBean() {
		return contentBean;
	}

	public void setContentBean(ContentBean contentBean) {
		this.contentBean = contentBean;
	}

	public HeaderBean getHeaderBean() {
		return headerBean;
	}

	public void setHeaderBean(HeaderBean headerBean) {
		this.headerBean = headerBean;
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

}