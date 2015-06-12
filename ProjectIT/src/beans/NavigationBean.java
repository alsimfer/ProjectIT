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
	
    private ArrayList<Page> navigation; 

    public NavigationBean() {
        Navigation nav = new Navigation();
        this.navigation = nav.getNavigation();
    }
    
    public String navigate(Page page) {
    	this.contentBean.setContent(page.getContent());
    	return page.getSlug();
    }
    
    public ContentBean getContentBean() {
		return contentBean;
	}

	public void setContentBean(ContentBean contentBean) {
		this.contentBean = contentBean;
	}

	public ArrayList<Page> getNavigation() {
		return navigation;
	}

	public void setNavigation(ArrayList<Page> navigation) {
		this.navigation = navigation;
	}    
        
	
}
