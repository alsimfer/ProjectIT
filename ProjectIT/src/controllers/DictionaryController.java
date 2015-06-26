package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

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
	
	private List<DictionaryEntry> dictionaryEntries = new ArrayList<DictionaryEntry>();
	
	private List<DictionaryEntry> userDictionaryEntries = new ArrayList<DictionaryEntry>();

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
		dictionaryDB = getDictionaryDB();
		
		isAdded = dictionaryDB.addNewWordToDictionary(dictionaryBean.getDictionaryEntry());
		
		if(loginBean != null) {
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
}
