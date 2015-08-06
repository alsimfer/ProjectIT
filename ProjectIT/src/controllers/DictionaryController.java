package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.SelectEvent;

import objects.DictionaryEntry;
import daoimpl.DictionaryDB;
import beans.ContentBean;
import beans.DictionaryBean;
import beans.LoginBean;

/**
 * Klasse DictionaryController ist für das Hinzufügen neuer Wörter, das Aktualisieren und das Löschen 
 * von vorhandenen Wörtern in einem vom Benutzer eingelegten Wörterbuch verantwortlich.
 *
 */

@ManagedBean
@RequestScoped
public class DictionaryController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{dictionaryBean}")
	private DictionaryBean dictionaryBean;
	
	@ManagedProperty(value="#{contentBean}")
	private ContentBean contentBean;
	
	@ManagedProperty(value="#{loginBean}")	
	private LoginBean loginBean;
	
	private DictionaryDB dictionaryDB;
	
	private boolean isAdded = false;
	private boolean isDeleted = false;
	private boolean isUpdated = false;
	
	private List<DictionaryEntry> dictionaryEntries = new ArrayList<DictionaryEntry>();
	
	private List<DictionaryEntry> userDictionaryEntries = new ArrayList<DictionaryEntry>();
	
	private DictionaryEntry selectedTableEntry;

	@PostConstruct
	public void init() {
	}
	
	public DictionaryBean getDictionaryBean() {
		return dictionaryBean;
	}

	public void setDictionaryBean(DictionaryBean dictionaryBean) {
		this.dictionaryBean = dictionaryBean;
	}
	
	/**
	 * Hinzufügen neuer Wörter ins Benutzer-Wörterbuch.
	 */
	public void addNewWord(){		
		if(loginBean != null) { // prüft ob ein Benutzer angemeldet ist
			dictionaryDB = getDictionaryDB();
			
			// isAdded wird auf true gesetzt, wenn das Hinzufügen erfolgreich war, sonst false.
			isAdded = dictionaryDB.addNewWordToDictionary(dictionaryBean.getDictionaryEntry());
			
			// aktualisiere den Wörtebucheintrag mit entsprechende id
			dictionaryBean.setDictionaryEntry(dictionaryDB.getDictionaryEntryFromDB(dictionaryBean.getDictionaryEntry()));
			if(isAdded) {
				
				// fügt das neue Wort dem aktiven Benutzer hinzu
				// isAdded ist true, wenn das Hinzufügen erfolgreich war, sonst false.
				isAdded = dictionaryDB.addNewUserWordToDictionary(dictionaryBean.getDictionaryEntry(), loginBean.getActiveUser());
			}
		}
		
		if(isAdded) {
			contentBean.setContent(contentBean.getContent() + "\n" + "The Adding is successful!");
			dictionaryBean.setDictionaryEntry(new DictionaryEntry());
		} else {
			contentBean.setContent(contentBean.getContent() + "\n" + "The Adding is failed!");
		}
	}
	
	/**
	 * Löschen eines Worts aus dem Benutzer-Wörterbuch.
	 */
	public void deleteUserWord() {
		if(loginBean != null) { // prüft ob ein Benutzer angemeldet ist
			dictionaryDB = getDictionaryDB();
		
			// holt den entsprechende Wörtebucheintrag aus dem DB mit id
			dictionaryBean.setDictionaryEntry(dictionaryDB.getDictionaryEntryFromDB(dictionaryBean.getDictionaryEntry()));
			
			// isDeleted wird auf true gesetzt, wenn das Löschen erfolgreich war, sonst false.
			isDeleted = dictionaryDB.deletWordFromUserDB(dictionaryBean.getDictionaryEntry(), loginBean.getActiveUser());
		}
		
		if(isDeleted) {
			contentBean.setContent(contentBean.getContent() + "\n" + "Delete is successful!");
			dictionaryBean.setDictionaryEntry(new DictionaryEntry());
		} else {
			contentBean.setContent(contentBean.getContent() + "\n" + "Delete is failed!");
		}
	}
	
	/**
	 * Aktualisieren eines Worts im Benutzer-Wörterbuch.
	 */
	public void updateUserWord() {
		if(loginBean != null) { // prüft ob ein Benutzer angemeldet ist
			dictionaryDB = getDictionaryDB();
		
			// holt den entsprechende Wörtebucheintrag aus dem DB mit id
			dictionaryBean.setDictionaryEntry(dictionaryDB.getDictionaryEntryFromDB(dictionaryBean.getDictionaryEntry()));
			
			// isUpdated wird auf true gesetzt, wenn das Aktualisieren erfolgreich war, sonst false.
			isUpdated = dictionaryDB.updateWordInDB(dictionaryBean.getDictionaryEntry());
		}
		
		if(isUpdated) {
			contentBean.setContent(contentBean.getContent() + "\n" + "Update is successful!");
			dictionaryBean.setDictionaryEntry(new DictionaryEntry());
		} else {
			contentBean.setContent(contentBean.getContent() + "\n" + "Update is failed!");
		}
	}
	
	/**
	 * Setzt den aktuellen Wörterbucheintrag wenn ein Tabelleneintrag auf der Wörterbuch-Seite
	 * vom Benutzer ausgewählt wird.
	 * 
	 * @param event wenn ein Tabelleneintrag ausgewählt wird.
	 */
	public void onRowSelect(SelectEvent event) {
		dictionaryBean.setDictionaryEntry(getSelectedTableEntry());
	}

	public ContentBean getContentBean() {
		return contentBean;
	}

	public void setContentBean(ContentBean contentBean) {
		this.contentBean = contentBean;
	}
	
	public DictionaryDB getDictionaryDB() {
		if(dictionaryDB == null) {
			dictionaryDB = new DictionaryDB();
		}
		return dictionaryDB;
	}

	/**
	 * Gibt alle Wörterbucheintrage aus dem DB zurück.
	 */
	public List<DictionaryEntry> getDictionaryEntries() {
		dictionaryDB = getDictionaryDB();
		dictionaryEntries = dictionaryDB.getAllDictionaryEntriesFromDB();
		return dictionaryEntries;
	}

	public void setDictionaryEntries(List<DictionaryEntry> dictionaryEntries) {
		this.dictionaryEntries = dictionaryEntries;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	/**
	 * Gibt Benutzer-Wörterbucheintrage aus dem DB zurück.
	 */
	public List<DictionaryEntry> getUserDictionaryEntries() {
		dictionaryDB = getDictionaryDB();
		userDictionaryEntries = dictionaryDB.getUserDictionaryEntriesFromDB(loginBean.getActiveUser().getId());
		return userDictionaryEntries;
	}

	public void setUserDictionaryEntries(List<DictionaryEntry> userDictionaryEntries) {
		this.userDictionaryEntries = userDictionaryEntries;
	}

	public DictionaryEntry getSelectedTableEntry() {
		return selectedTableEntry;
	}

	public void setSelectedTableEntry(DictionaryEntry selectedTableEntry) {
		this.selectedTableEntry = selectedTableEntry;
	}
}
