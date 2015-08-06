package beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;

import objects.*;

/**
 * Die Klasse QuestionBean repräsentiert die Testfragen und mögliche Antworten.
 *
 */

@ManagedBean
@ViewScoped
public class QuestionBean implements Serializable {

	// Variables -------------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
	private String question, answerA, answerB, answerC, answerD, acceptedAnswer;
	private int counter, questionsAmount, correctAnswers;
	
	private Test test;
	
    // Properties ------------------------------------------------------------------------------------------------------
	@ManagedProperty("#{testFormBean}")
	private TestFormBean testFormBean;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
    // Init ------------------------------------------------------------------------------------------------------------	
	@PostConstruct
	/**
	 * Collect the values from testFormBean and initialize test object, where the test functionality is encapsulated.
	 * Will be instantiated just once when view starts, then works with the help of questionController.
	 */
	public void init() {
		this.questionsAmount = testFormBean.getAmount();	
		int userId = loginBean.getActiveUser().getId();
		boolean other = testFormBean.getOther();
		String langQuestion = testFormBean.getLangQuestion();
		String langAnswer = testFormBean.getLangAnswer();
		this.test = new Test(userId, this.questionsAmount, other, langQuestion, langAnswer);
		
		this.counter = 0;
		this.correctAnswers = 0;
        ArrayList<String> nextQuestion = test.getNextQuestion();
        this.question = nextQuestion.get(0);
        this.answerA = nextQuestion.get(1);
        this.answerB = nextQuestion.get(2);
        this.answerC = nextQuestion.get(3);
        this.answerD = nextQuestion.get(4);
        this.counter++;
	}
	
    // Getters/setters ------------------------------------------------------------------------------------------------- 
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswerA() {
		return answerA;
	}

	public void setAnswerA(String answerA) {
		this.answerA = answerA;	
	}

	public String getAnswerB() {
		return answerB;
	}

	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}

	public String getAnswerC() {
		return answerC;
	}

	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}

	public String getAnswerD() {
		return answerD;
	}

	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}

	public String getAcceptedAnswer() {
		return acceptedAnswer;
	}

	public void setAcceptedAnswer(String acceptedAnswer) {
		this.acceptedAnswer = acceptedAnswer;
	}

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

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getQuestionsAmount() {
		return questionsAmount;
	}

	public void setQuestionsAmount(int questionsAmount) {
		this.questionsAmount = questionsAmount;
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}