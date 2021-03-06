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

	private static final long serialVersionUID = 1L;
	final String baseName = "languageProperties.Language";
	boolean checked;
	
	// Keys in Language_xx.properties
	final String lg_key_notEnoughWordsForTest = "test_message_notEnoughWordsForTest";
	final String lg_key_amountOfQuestionsRequiered = "test_message_amountOfQuestionsRequiered";
	
	// Variables -------------------------------------------------------------------------------------------------------	
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
		answerLanguages = new LinkedHashMap<String, String>();
    	switch (questionLanguage) {
	    	case "english": 
	        	answerLanguages.put("Deutsch", "german");
	        	answerLanguages.put("Русский", "russian");
	        	break;
	    	case "german": 
	        	answerLanguages.put("English", "english");
	        	answerLanguages.put("Русский", "russian");
	        	break;
	    	case "russian": 
	        	answerLanguages.put("English", "english");
	        	answerLanguages.put("Deutsch", "german");
	        	break;
	    	default: 
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
		String param = "off";
		
		 // param = "on" if checked, else "off".
		try {
			param = (String) component.getAttributes().get("param");
		} catch (NullPointerException e) {
		}
		finally {
			if (param == null) {
				param = "off";
			}
		}
		
		int userId = loginBean.getActiveUser().getId();
		DictionaryDB ddb = new DictionaryDB();
		List<DictionaryEntry> words = ddb.getUserDictionaryEntriesFromDB(userId);
		int totalWords = words.size();

	  	if (setAmount < 5) {
	  		// Internalisation der Meldungen
	  		String message = ResourceBundle.getBundle(baseName, loginBean.getLanguageBean().getLocale()).getString(lg_key_amountOfQuestionsRequiered);
		  	throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	  	}
		
	  	if ((totalWords < setAmount) && (userId > 0) && (!param.equals("on"))) {
	  		// Internalisation der Meldungen
	  		String message = ResourceBundle.getBundle(baseName, loginBean.getLanguageBean().getLocale()).getString(lg_key_notEnoughWordsForTest);
		  	throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	  	}
	}

    public void other(Boolean checked) {
    	this.checked = checked;
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