package beans;

import static util.UtilFunctions.*;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;

import objects.*;

@ManagedBean
@SessionScoped
public class ContentBean implements Serializable {
	
	// Variables -------------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
    private String content;
		
    // Init ------------------------------------------------------------------------------------------------------------
    // By default we always initialize the main page, if the session was just started. 
	@PostConstruct
    public void init() {
		Page page = new Navigation().getPageById(1);
    	this.content = page.getContent();
    }
    
    // Getters/setters -------------------------------------------------------------------------------------------------    
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	} 
        
}
