package beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;

import objects.DictionaryEntry;

/**
 * Die Klasse DictionaryBean repräsentiert ein Wörterbucheintrag.
 *
 */

@ManagedBean
@ViewScoped
public class DictionaryBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private DictionaryEntry dictionaryEntry;
	
	@PostConstruct
    public void init() {
		this.dictionaryEntry = new DictionaryEntry();
	}
	
	public DictionaryEntry getDictionaryEntry() {
		return dictionaryEntry;
	}
	public void setDictionaryEntry(DictionaryEntry dictionaryEntry) {
		this.dictionaryEntry = dictionaryEntry;
	}
	
}
