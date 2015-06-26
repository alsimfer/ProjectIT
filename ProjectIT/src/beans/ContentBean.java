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
	@PostConstruct
    public void init() {
    }
    
    // Getters/setters -------------------------------------------------------------------------------------------------    
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	} 
        
}
