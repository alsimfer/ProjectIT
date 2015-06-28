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
	
	public boolean deletWordFromUserDB(DictionaryEntry entry, User user) {
		String query1 = "Delete from user_dictionary where "
				+ "user_id = " + user.getId() + " and "
				+ "dictionary_id = " + getDictionaryEntryFromDB(entry).getIdEntry() + ";";
//		String query2 = "Delete from dictionary where "
//				+ "id = " + getDictionaryEntryFromDB(entry).getIdEntry() + ";";
		if(getDbc() != null) {
			Connection con = getDbc().connect();
			query(query1, con);
//			query(query2, con);
			if(getUpdateResult() == 1) {
				closeConnection();
				return true;
			}
			closeConnection();
		}
		return false;
	}
	
	public boolean updateWordInDB(DictionaryEntry entry) {
		String query = "Update dictionary set "
				+ "english = " + "'" + entry.getEnEntry() + "', "
				+ "german = " + "'" + entry.getGeEntry() + "', "
				+ "russian = " + "'" + entry.getRuEntry() + "' "
				+ "where id = " + getDictionaryEntryFromDB(entry).getIdEntry() 
				+ ";";
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
	
	public String[] getWordsById(int id) {
		String query = "SELECT "
				+ "english, "
				+ "german, "
				+ "russian "
				+ "FROM dictionary WHERE id = " + id;
		
		String english = "", german = "", russian = "", tmp = "";
		Object [][] resultData;
		String[] returnArray;
		
		if(getDbc() != null) {	
			Connection con = getDbc().connect();
			query(query, con);
			resultData = getResultData();
			
			if (resultData != null) {
				tmp = (String) resultData[0][0];
				english = (tmp.length() > 0) ? tmp : "";
				tmp = (String) resultData[0][1];
				german = (tmp.length() > 0) ? tmp : "";
				tmp = (String) resultData[0][2];
				russian = (tmp.length() > 0) ? tmp : "";			
			}
			closeConnection();
		}
		
		returnArray = new String[] {english, german, russian};
		return returnArray;
	}
	
	public int[] getDictionaryIds(int user_id) {
		String query;
		if (user_id == 0) {
			query = "SELECT "
					+ "id "
					+ "FROM dictionary";
		} else {			
			query = "SELECT "
					+ "dictionary_id "
					+ "FROM user_dictionary WHERE user_id = " + user_id;
		}

		Object [][] resultData;
		
		if(getDbc() != null) {	
			Connection con = getDbc().connect();
			query(query, con);
			resultData = getResultData();
	
			if (resultData != null) {
				int[] returnArray = new int[resultData.length];
				
				for (int i = 0; i < resultData.length; i++) {
					returnArray[i] = (int) resultData[i][0];
				}
				closeConnection();
				return returnArray;
			}
			closeConnection();
		}
		return new int[0];
	}
	
	public List<DictionaryEntry> getUserDictionaryEntriesFromDB(int userId) {
		String query = "Select dictionary.id, english, german, russian from dictionary, user_dictionary "
				+ "where user_id = " + userId + " and dictionary_id = dictionary.id;";
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
