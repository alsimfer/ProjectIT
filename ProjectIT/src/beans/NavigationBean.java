package beans;

import static util.UtilFunctions.*;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import objects.*;

@ManagedBean
@SessionScoped

public class NavigationBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
    
	@ManagedProperty(value="#{contentBean}")
	private ContentBean contentBean;
	
	@ManagedProperty(value="#{headerBean}")
	private HeaderBean headerBean;
	
    private ArrayList<Page> navigation; 
    private String language;

    public NavigationBean() {
        Navigation nav = new Navigation();
        this.navigation = nav.getNavigation();
    }
    
    public String navigate(Page page) {
    	this.contentBean.setContent(page.getContent());
    	this.headerBean.setTitle(page.getTitle());
    	return page.getSlug();
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

}
