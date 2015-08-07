package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
	
	final String baseName = "languageProperties.Language";
	// Keys in Language_xx.properties
	final String lg_key_addingSuccessful = "dictionary_message_addingIsSuccessful";
	final String lg_key_updateSuccessful = "dictionary_message_updateIsSuccessful";
	final String lg_key_deleteSuccessful = "dictionary_message_deleteIsSuccessful";
	final String lg_key_updateFailed = "dictionary_message_updateIsFailed";
	final String lg_key_addingFailed = "dictionary_message_addingIsFailed";
	final String lg_key_deleteFailed = "dictionary_message_deleteIsFailed";
	
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
			// Internalisation der Meldungen
			String message = ResourceBundle.getBundle(baseName, loginBean.getLanguageBean().getLocale()).getString(lg_key_addingSuccessful);
			contentBean.setContent(contentBean.getContent() + "\n" + message);
			dictionaryBean.setDictionaryEntry(new DictionaryEntry());
		} else {
			String message = ResourceBundle.getBundle(baseName, loginBean.getLanguageBean().getLocale()).getString(lg_key_addingFailed);
			contentBean.setContent(contentBean.getContent() + "\n" + message);
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
			// Internalisation der Meldungen
			String message = ResourceBundle.getBundle(baseName, loginBean.getLanguageBean().getLocale()).getString(lg_key_deleteSuccessful);
			contentBean.setContent(contentBean.getContent() + "\n" + message);
			dictionaryBean.setDictionaryEntry(new DictionaryEntry());
		} else {
			String message = ResourceBundle.getBundle(baseName, loginBean.getLanguageBean().getLocale()).getString(lg_key_deleteFailed);
			contentBean.setContent(contentBean.getContent() + "\n" + message);
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
			// Internalisation der Meldungen
			String message = ResourceBundle.getBundle(baseName, loginBean.getLanguageBean().getLocale()).getString(lg_key_updateSuccessful);
			contentBean.setContent(contentBean.getContent() + "\n" + message);
			dictionaryBean.setDictionaryEntry(new DictionaryEntry());
		} else {
			String message = ResourceBundle.getBundle(baseName, loginBean.getLanguageBean().getLocale()).getString(lg_key_updateFailed);
			contentBean.setContent(contentBean.getContent() + "\n" + message);
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
