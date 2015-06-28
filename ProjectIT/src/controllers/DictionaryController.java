package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import objects.DictionaryEntry;
import daoimpl.DictionaryDB;
import beans.ContentBean;
import beans.DictionaryBean;
import beans.LoginBean;
import static util.UtilFunctions.*; 

@ManagedBean
@RequestScoped
public class DictionaryController {
	
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
	
	public void addNewWord() {		
		if(loginBean != null) {
			dictionaryDB = getDictionaryDB();
			isAdded = dictionaryDB.addNewWordToDictionary(dictionaryBean.getDictionaryEntry());
		
			dictionaryBean.setDictionaryEntry(dictionaryDB.getDictionaryEntryFromDB(dictionaryBean.getDictionaryEntry()));
			isAdded = dictionaryDB.addNewUserWordToDictionary(dictionaryBean.getDictionaryEntry(), loginBean.getActiveUser());
		}
		
		if(isAdded) {
			contentBean.setContent("The Adding is successful!");
			dictionaryBean.setDictionaryEntry(new DictionaryEntry());
		} else {
			contentBean.setContent("The Adding is failed!");
		}
	}
	
	public void deleteUserWord() {
		if(loginBean != null) {
			dictionaryDB = getDictionaryDB();
		
			dictionaryBean.setDictionaryEntry(dictionaryDB.getDictionaryEntryFromDB(dictionaryBean.getDictionaryEntry()));
			isDeleted = dictionaryDB.deletWordFromUserDB(dictionaryBean.getDictionaryEntry(), loginBean.getActiveUser());
		}
		
		if(isDeleted) {
			contentBean.setContent("Delete is successful!");
			dictionaryBean.setDictionaryEntry(new DictionaryEntry());
		} else {
			contentBean.setContent("Delete is failed!");
		}
	}
	
	public void updateUserWord() {
		if(loginBean != null) {
			dictionaryDB = getDictionaryDB();
		
			dictionaryBean.setDictionaryEntry(dictionaryDB.getDictionaryEntryFromDB(dictionaryBean.getDictionaryEntry()));
			isUpdated = dictionaryDB.updateWordInDB(dictionaryBean.getDictionaryEntry());
		}
		
		if(isUpdated) {
			contentBean.setContent("Update is successful!");
			dictionaryBean.setDictionaryEntry(new DictionaryEntry());
		} else {
			contentBean.setContent("Update is failed!");
		}
	}
	
	public void onRowSelect(SelectEvent event) {
		dictionaryBean.setDictionaryEntry(getSelectedTableEntry());
	}
	
	public void onRowUnselect(UnselectEvent event) {
		setSelectedTableEntry(null);
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
