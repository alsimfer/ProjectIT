package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import daoimpl.DictionaryDB;
import beans.ContentBean;
import beans.DictionaryBean;
import beans.LoginBean;

@ManagedBean
@SessionScoped
public class DictionaryController {
	
	@ManagedProperty(value = "#{dictionaryBean}")
	private DictionaryBean dictionaryBean;
	
	@ManagedProperty(value="#{contentBean}")
	private ContentBean contentBean;
	
	private LoginBean loginBean;
	private DictionaryDB dictionaryDB;
	
	private boolean isAdded = false;

	public DictionaryBean getDictionaryBean() {
		return dictionaryBean;
	}

	public void setDictionaryBean(DictionaryBean dictionaryBean) {
		this.dictionaryBean = dictionaryBean;
	}
	
	public void addNewWord() {
		if(dictionaryDB == null) {
			dictionaryDB = new DictionaryDB();
		}
		
		isAdded = dictionaryDB.addNewWordToDictionary(dictionaryBean.getDictionaryEntry());
		dictionaryBean.setDictionaryEntry(dictionaryDB.getDictionaryEntryFromDB(dictionaryBean.getDictionaryEntry()));
		if(loginBean != null) {
			isAdded = dictionaryDB.addNewUserWordToDictionary(dictionaryBean.getDictionaryEntry(), loginBean.getUser());
		}
		
		if(isAdded) {
			contentBean.setContent("The Adding is successful!");
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
}
