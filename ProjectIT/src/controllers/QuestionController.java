package controllers;

import static util.UtilFunctions.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;

import objects.*;
import beans.*;
import daoimpl.*;

/**
 * Klasse QuestionController ist für die Durchführung von Tests verantwortlich.
 * Speichert Statistiken nach jeder Testdurchführung.
 *
 */

@ManagedBean
@RequestScoped
public class QuestionController implements Serializable {

	private static final long serialVersionUID = 1L;
	final String baseName = "languageProperties.Language";
	// Keys in Language_xx.properties
	final String lg_key_testIsPassed = "question_message_testIsPassed";
	
	// Variables -------------------------------------------------------------------------------------------------------
	private Test test;    
    
    // Properties ------------------------------------------------------------------------------------------------------
	@ManagedProperty("#{testFormBean}")
	private TestFormBean testFormBean;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	@ManagedProperty("#{questionBean}")
	private QuestionBean questionBean;
	
	@ManagedProperty("#{navigationController}")
	private NavigationController navigationController;
	
    // Init ------------------------------------------------------------------------------------------------------------	
	@PostConstruct
	/**
	 * Collect the values from questionBean.
	 */
	public void init() {
		this.test = questionBean.getTest();
	}
	
	// Actions ---------------------------------------------------------------------------------------------------------
	/**
	 * Check the answer for the actual question and set values for the next test-iteration.
	 * 
	 */
    public String next(String answer) {
    	String acceptedAnswer = "";
    	switch (answer) {
			case "A": acceptedAnswer = questionBean.getAnswerA();
			break;
		
			case "B": acceptedAnswer = questionBean.getAnswerB();
			break;
		
			case "C": acceptedAnswer = questionBean.getAnswerC();
			break;
		
			case "D": acceptedAnswer = questionBean.getAnswerD();
			break;
			
			default: acceptedAnswer = questionBean.getAnswerA();
	        break;
    	}
    	
    	if (test.checkAnswer(acceptedAnswer) == true) {
    		int tmp = questionBean.getCorrectAnswers();
    		tmp++;
    		questionBean.setCorrectAnswers(tmp);
    	};

    	if (questionBean.getCounter() >= questionBean.getQuestionsAmount()) {
    		this.setStatistics();
    		// Internalisation der Meldungen
    		String message = ResourceBundle.getBundle(baseName, loginBean.getLanguageBean().getLocale()).getString(lg_key_testIsPassed);
    		return navigationController.moveToMain(message);
    	}
    	
		this.initQuestion();
		return "";    	
    }

    /**
     * Add statistics about this test to the DB.
     */
    public void setStatistics() {
    	StatsDB statsDB = new StatsDB();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    	String localeQuestion = getLocale(testFormBean.getLangQuestion());
    	String localeAnswer = getLocale(testFormBean.getLangAnswer());    	
    	
    	String date = dateFormat.format(new Date());
    	statsDB.addStats(
			loginBean.getActiveUser().getId(),
			date,
			questionBean.getCorrectAnswers(), 
			questionBean.getCounter(), 
			localeQuestion,
			localeAnswer
		);
    	
    }

	
    /** 
	 * Get the next question from test object and set the values for the bean.
	 */
    public void initQuestion() {
		int counter = questionBean.getCounter();
		counter++;
		questionBean.setCounter(counter);
        ArrayList<String> nextQuestion = test.getNextQuestion();
        questionBean.setQuestion(nextQuestion.get(0));
        questionBean.setAnswerA(nextQuestion.get(1));
        questionBean.setAnswerB(nextQuestion.get(2));
        questionBean.setAnswerC(nextQuestion.get(3));
        questionBean.setAnswerD(nextQuestion.get(4));        
    }

    // Getters/setters ------------------------------------------------------------------------------------------------- 
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public TestFormBean getTestFormBean() {
		return testFormBean;
	}

	public void setTestFormBean(TestFormBean testFormBean) {
		this.testFormBean = testFormBean;
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public QuestionBean getQuestionBean() {
		return questionBean;
	}

	public void setQuestionBean(QuestionBean questionBean) {
		this.questionBean = questionBean;
	}

	public NavigationController getNavigationController() {
		return navigationController;
	}

	public void setNavigationController(NavigationController navigationController) {
		this.navigationController = navigationController;
	}

}