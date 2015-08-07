package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static util.UtilFunctions.*;

/**
 * This class represents test functionality. 
 * Is initialized in QuestionBean. 
 * Gets the words from db depending on settings, mixes possible answers, checks the result, calculates statistics. 
 * 
 * @author Alex
 */
public class Test implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String langQuestion, langAnswer, correctAnswer;
	private boolean other;
	private int userId, amount, counter, correctAnswers;
	private int[] dictionary_ids;
	private ArrayList<Integer> askedWordsIds = new ArrayList<Integer>();
	
	public Test(int userId, int amount, boolean other, String langQuestion, String langAnswer) {
		super();
		this.langQuestion = langQuestion;
		this.langAnswer = langAnswer;
		this.other = other;
		this.userId = userId;
		this.counter = 0;
		
		// Get the words of this user if was asked for. Not logged in user will get all words from db.
		UserDictionary ud;
		if (other == true) {
			ud = new UserDictionary(0);	
		} else {
			ud = new UserDictionary(userId);	
		}
		
		this.dictionary_ids = ud.getDictionaryIds();
		
		// Check if there are enough words in the dictionary.
		if (amount > this.dictionary_ids.length) {
			this.amount = this.dictionary_ids.length;
		} else {
			this.amount = amount;
		}
	}
	
	/**
	 * Check if the given answer is correct.
	 * 
	 * @param answer
	 * @return if answer is correct
	 */
	public boolean checkAnswer(String answer) {
		if (answer.equals(correctAnswer)) {
			this.correctAnswers++;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Get the words for the next question from the db, remember the correct answer, mix the values.
	 * 
	 * @return question and answers as ArrayList.
	 */
	public ArrayList<String> getNextQuestion() { 
		// ArrayList with 4 possible answers.
		ArrayList<String> answers = new ArrayList<String>();
		
		if (this.amount > this.counter) {
			// pick a random word from all relevant and save it as question and correct answer value.
			int rand = nextIntInRangeButExclude(this.dictionary_ids, this.askedWordsIds);
			this.askedWordsIds.add((Integer) rand);
			
			DictionaryEntry questionWord = new DictionaryEntry(rand);
			String question = questionWord.getWordByLanguage(this.getLangQuestion());
			this.correctAnswer = questionWord.getWordByLanguage(this.getLangAnswer());
			answers.add(this.correctAnswer);
	
			// Get another 3 random answers from all relevant and exclude those already added as possible answer.
			ArrayList<Integer> answerIds = new ArrayList<Integer>();
			answerIds.addAll(this.askedWordsIds);
			for (int i = 0; i <= 2; i++) {
				rand = nextIntInRangeButExclude(this.dictionary_ids, answerIds);
				DictionaryEntry possibleAnswerWord = new DictionaryEntry(rand);
				answers.add(possibleAnswerWord.getWordByLanguage(this.getLangAnswer()));
				answerIds.add((Integer) rand);
			}
			
			// Shuffle values to avoid correct answer being on the first place. 
			Collections.shuffle(answers);
			
			// Add question itself
			answers.add(0, question);
			
		} else {
			answers.add("The test is over");
			answers.add("The test is over");
			answers.add("The test is over");
			answers.add("The test is over");
			answers.add("The test is over");
		}
		
		this.counter++;

		return answers;
	}
	
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
	
	public boolean isOther() {
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

	@Override
	public String toString() {
		return "Test [langQuestion=" + langQuestion + ", langAnswer="
				+ langAnswer + ", correctAnswer=" + correctAnswer + ", other="
				+ other + ", userId=" + userId + ", amount=" + amount
				+ ", counter=" + counter + ", correctAnswers=" + correctAnswers
				+ ", dictionary_ids=" + Arrays.toString(dictionary_ids)
				+ ", askedWordsIds=" + askedWordsIds + "]";
	}	
	
}
