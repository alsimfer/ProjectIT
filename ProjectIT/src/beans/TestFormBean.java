package beans;

import static util.UtilFunctions.p;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;

/**
 * Die Klasse TestFormBean repräsentiert die Testparameter, die für die Durchführung eines Tests erforderlich sind.
 * 
 */

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
		// At least 5 questions per test.
		amount = 5;
	}
	
	public void exclude() {
		p("Hallo");
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