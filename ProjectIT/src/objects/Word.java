package objects;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import static util.UtilFunctions.*;
import db.*;

/**
 * This class represents the object from dictionary.dictionary db-entry.
 * 
 * @author Alex
 */
public class Word implements Serializable
{
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Word.class.getName());
	
	private int id;
	private String english, german, russian;
	
	private DBQuery query;
	
	// Initialize page from DB using id.
	public Word(int id)
	{		
		this.id = id;
		
		this.query = new DBQuery();
		String[] words = query.getWordsById(id);
		this.query.closeConnection();
		
		this.english = words[0];
		this.german = words[1];
		this.russian = words[2];
	}

	public Word(int id, String english, String german, String russian,
			DBQuery query) {
		super();
		this.id = id;
		this.english = english;
		this.german = german;
		this.russian = russian;
		this.query = query;
	}

	public String getWordByLanguage(String language) {
		String word = "";
		switch (language) {
			case "english": word = this.getEnglish();
			break;
		
			case "german": word = this.getGerman();
			break;
		
			case "russian": word = this.getRussian();
			break;
			
			default: word = this.getEnglish();
	        break;
		}
        
        return word;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getGerman() {
		return german;
	}

	public void setGerman(String german) {
		this.german = german;
	}

	public String getRussian() {
		return russian;
	}

	public void setRussian(String russian) {
		this.russian = russian;
	}

	@Override
	public String toString() {
		return "Word [id=" + id + ", english=" + english + ", german=" + german
				+ ", russian=" + russian + "]";
	}			
	
}
