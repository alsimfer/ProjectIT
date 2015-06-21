package daoimpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import objects.DictionaryEntry;
import objects.User;
import db.DBQuery;

public class DictionaryDB extends DBQuery{
	
	public DictionaryDB() {
		super();
	}

	public boolean addNewWordToDictionary(DictionaryEntry entry) {
		String query = "Insert into dictionary values "
				+ "(DEFAULT, "
				+ "'" + entry.getEnEntry() + "', "
				+ "'" + entry.getGeEntry() + "', "
				+ "'" + entry.getRuEntry() + "');";	
		if(getDbc() != null) {
			Connection con = getDbc().connect();
			query(query, con);
			if(getUpdateResult() == 1) {
				closeConnection();
				return true;
			}
		closeConnection();
		}
		return false;
	}
	
	public boolean addNewUserWordToDictionary(DictionaryEntry entry, User user) {
		String query = "Insert into user_dictionary values "
				+ "(" + user.getId() + ", "
				+ "" + getDictionaryEntryFromDB(entry).getIdEntry() + ");";
		if(getDbc() != null) {
			Connection con = getDbc().connect();
			query(query, con);
			if(getUpdateResult() == 1) {
				closeConnection();
				return true;
			}
			closeConnection();
		}
		return false;
	}
	
	public DictionaryEntry getDictionaryEntryFromDB(DictionaryEntry entry) {
		String query = "Select id from dictionary where "
				+ "english = " + "'" + entry.getEnEntry() + "' and "
				+ "german = " + "'" + entry.getGeEntry() + "' and "
				+ "russian = " + "'" + entry.getRuEntry() + "';";
		if(getDbc() != null) {		
			Connection con = getDbc().connect();
			query(query, con);
			Object[][] result = getResultData();
			if(result != null) {	
				entry.setIdEntry(((Integer)result[0][0]).intValue());
			}
			closeConnection();
		}
		return entry;
	}
	
	public List<DictionaryEntry> getAllDictionaryEntriesFromDB() {
		String query = "Select * from dictionary;";
		List<DictionaryEntry> list = new ArrayList<DictionaryEntry>();
		DictionaryEntry entry;
		if(getDbc() != null) {	
			Connection con = getDbc().connect();
			query(query, con);
			Object[][] result = getResultData();
			if(result != null) {
				for(int i = 0; i < result.length; i++) {
					entry = new DictionaryEntry();
					entry.setIdEntry(((Integer)result[i][0]).intValue());
					entry.setEnEntry(result[i][1].toString());
					entry.setGeEntry(result[i][2].toString());
					entry.setRuEntry(result[i][3].toString());
					list.add(entry);
				}
			}
			closeConnection();
		}
		return list;
	}
}
