package objects;

import java.io.Serializable;
import java.util.logging.Logger;

import daoimpl.DictionaryDB;

/**
 * This class represents the object from dictionary.dictionary db-entry.
 * 
 */
public class DictionaryEntry implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(DictionaryEntry.class.getName());
	
	private String geEntry;
	private String enEntry;
	private String ruEntry;
	
	private int idEntry;
	
	private DictionaryDB dictionaryDB;
	
	public DictionaryEntry() {}
	
	public DictionaryEntry(int id)
	{		
		this.idEntry = id;
			
		this.dictionaryDB = new DictionaryDB();
		String[] words = dictionaryDB.getWordsById(id);
		
		this.enEntry = words[0];
		this.geEntry = words[1];
		this.ruEntry = words[2];
	}
	
	public String getGeEntry() {
		return geEntry;
	}
	public void setGeEntry(String geEntry) {
		this.geEntry = geEntry;
	}
	public String getEnEntry() {
		return enEntry;
	}
	public void setEnEntry(String enEntry) {
		this.enEntry = enEntry;
	}
	public String getRuEntry() {
		return ruEntry;
	}
	public void setRuEntry(String ruEntry) {
		this.ruEntry = ruEntry;
	}
	public int getIdEntry() {
		return idEntry;
	}
	public void setIdEntry(int idEntry) {
		this.idEntry = idEntry;
	}
	
	public String getWordByLanguage(String language) {
		String word = "";
		switch (language) {
			case "english": word = getEnEntry();
			break;
		
			case "german": word = getGeEntry();
			break;
		
			case "russian": word = getRuEntry();
			break;
			
			default: word = getEnEntry();
	        break;
		}
        
        return word;
	}
	
	@Override
	public String toString() {
		return "DictionaryEntry [geEntry=" + geEntry + ", enEntry=" + enEntry
				+ ", ruEntry=" + ruEntry + ", idEntry=" + idEntry + "]";
	}
}
