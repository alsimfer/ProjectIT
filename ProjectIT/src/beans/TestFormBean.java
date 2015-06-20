package beans;

import static util.UtilFunctions.invalidateSession;
import static util.UtilFunctions.p;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;

import objects.*;

@ManagedBean
@SessionScoped
public class TestFormBean implements Serializable {

	// Variables -------------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
	private String langQuestion, langAnswer;
	private boolean other;
	private int amount;
    
	// Properties ------------------------------------------------------------------------------------------------------

	
    // Init ------------------------------------------------------------------------------------------------------------	
	@PostConstruct
	public void init() {
		
	}
	
	// Actions ---------------------------------------------------------------------------------------------------------	
    public String start() {
    	return "testPage.xhtml";
    }

    // Getters/setters ------------------------------------------------------------------------------------------------- 
	public String getLangQuestion() {
		return langQuestion;
	}

	public void setLangQuestion(String langQuestion) {
		this.langQuestion = langQuestion;
	}

	public String getLangAnswer() {
		return langAnswer;
	}

	public void setLangAnswer(String langAnswer) {
		this.langAnswer = langAnswer;
	}

	public boolean getOther() {
		return other;
	}

	public void setOther(boolean other) {
		this.other = other;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

   

}