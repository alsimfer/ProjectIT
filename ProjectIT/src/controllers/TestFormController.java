package controllers;

import static util.UtilFunctions.*;

import java.io.Serializable;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import objects.*;
import beans.*;
import daoimpl.*;

/**
 * A controller and validator for testForm. Used e.g. for the exclusion of the same languages for the question and answer. 
 */

@ManagedBean
@RequestScoped
public class TestFormController implements Serializable {

	// Variables -------------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
	
	private Map<String, String> answerLanguages;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	@ManagedProperty("#{testFormBean}")
	private TestFormBean testFormBean;
	
	// Actions ---------------------------------------------------------------------------------------------------------
	/**
	 * Function populates select field for the answer languages.
	 * 
	 * @param questionLanguage Value from select field of a question language of the testForm. 
	 */
    public Map<String, String> getAnswerLanguages(String questionLanguage) {
    	switch (questionLanguage) {
	    	case "english": 
	    		answerLanguages = new LinkedHashMap<String, String>();
	        	answerLanguages.put("Deutsch", "german");
	        	answerLanguages.put("Русский", "russian");
	        	break;
	    	case "german": 
	    		answerLanguages = new LinkedHashMap<String, String>();
	        	answerLanguages.put("English", "english");
	        	answerLanguages.put("Русский", "russian");
	        	break;
	    	case "russian": 
	    		answerLanguages = new LinkedHashMap<String, String>();
	        	answerLanguages.put("English", "english");
	        	answerLanguages.put("Deutsch", "german");
	        	break;
	    	default: 
	    		answerLanguages = new LinkedHashMap<String, String>();
	        	answerLanguages.put("Deutsch", "german");
	        	answerLanguages.put("Русский", "russian");
	        	break;
    	}
    	
	 	return answerLanguages;
    }
    
    /**
     * Checks if user has enough words in the db to go through test (5).
     */
    public void validateTestForm(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		int setAmount = (int) value;
		
		int userId = loginBean.getActiveUser().getId();
		DictionaryDB ddb = new DictionaryDB();
		List<DictionaryEntry> words = ddb.getUserDictionaryEntriesFromDB(userId);
		int totalWords = words.size();
		p("user " + userId);		
		p("setAmount " + setAmount);		
		p("totalWords " + totalWords);	
	  	if ((totalWords < setAmount) && (userId > 0)) {
		  	String msg = "You dont have enough words in your dictionary to start the test.";
		  	throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	  	}
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public TestFormBean getTestFormBean() {
		return testFormBean;
	}

	public void setTestFormBean(TestFormBean testFormBean) {
		this.testFormBean = testFormBean;
	}
	
}