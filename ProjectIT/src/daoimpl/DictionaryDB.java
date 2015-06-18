package daoimpl;

import objects.DictionaryEntry;
import objects.User;
import db.DBQuery;

public class DictionaryDB extends DBQuery{

	public boolean addNewWordToDictionary(DictionaryEntry entry) {
		String query = "Insert into dictionary values "
				+ "DEFAULT, "
				+ "'" + entry.getEnEntry() + "', "
				+ "'" + entry.getGeEntry() + "', "
				+ "'" + entry.getRuEntry() + "';";	
		if(getDbc() != null) {
			getDbc().query(query);
			if(getDbc().getUpdateResult() == 1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean addNewUserWordToDictionary(DictionaryEntry entry, User user) {
		String query = "Insert into user_dictionary values "
				+ "'" + user.getId() + "', "
				+ "'" + getDictionaryEntryFromDB(entry).getIdEntry() + "';";
		if(getDbc() != null) {
			getDbc().query(query);
			if(getDbc().getUpdateResult() == 1) {
				return true;
			}
		}
		return false;
	}
	
	public DictionaryEntry getDictionaryEntryFromDB(DictionaryEntry entry) {
		String query = "Select id from dictionary where "
				+ "english" + "'" + entry.getEnEntry() + "'"
				+ "german" + "'" + entry.getGeEntry() + "'"
				+ "russian" + "'" + entry.getRuEntry() + "';";
		if(getDbc() != null) {
			getDbc().query(query);
			entry.setIdEntry(Integer.parseInt(query));
		}
		return entry;
	}
}
