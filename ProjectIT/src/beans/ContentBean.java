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

public class ContentBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
    
    private String content;
    
/*    @ManagedProperty(value="#{navigationBean}")
    private NavigationBean navigationBean;
    
    public ContentBean() {
        
    }

    // This function should be triggered to update the managedProperties.
    public void getResult(String content) {
    	this.content = content;
p(content);
    }
    
	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}*/

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
 
        
}
