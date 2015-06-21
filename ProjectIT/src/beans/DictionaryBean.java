package beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import objects.DictionaryEntry;

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
