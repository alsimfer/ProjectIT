package beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;

import objects.*;


/**
 * Die Klasse ContentBean repräsentiert das entsprechende Seitenkontext.
 *
 */

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
