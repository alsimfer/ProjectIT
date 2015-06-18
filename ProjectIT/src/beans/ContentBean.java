package beans;

import static util.UtilFunctions.*;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import objects.*;

@ManagedBean
@SessionScoped

public class ContentBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
    
    private String content;
    
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
 
        
}
