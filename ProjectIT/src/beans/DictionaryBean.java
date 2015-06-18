package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import objects.DictionaryEntry;

@ManagedBean
@SessionScoped
public class DictionaryBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private DictionaryEntry dictionaryEntry;
	
	public DictionaryEntry getDictionaryEntry() {
		return dictionaryEntry;
	}
	public void setDictionaryEntry(DictionaryEntry dictionaryEntry) {
		this.dictionaryEntry = dictionaryEntry;
	}
	
}
