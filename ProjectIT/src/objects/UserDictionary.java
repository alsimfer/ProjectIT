package objects;

import java.io.Serializable;
import java.util.logging.Logger;

import daoimpl.DictionaryDB;

/**
 * This class represents the object from dictionary.user_dictionary db-entry.
 */
public class UserDictionary implements Serializable
{
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(UserDictionary.class.getName());
	
	private int user_id;
	private int[] dictionary_ids;
	private DictionaryDB dictionaryDB;
	
	public UserDictionary(int user_id, int[] dictionary_ids) {
		super();
		this.user_id = user_id;
		this.dictionary_ids = dictionary_ids;
	}

	// Initialize related dictionary_ids for this user.
	public UserDictionary(int user_id)
	{		
		this.user_id = user_id;
		
		this.dictionaryDB = new DictionaryDB();
		this.dictionary_ids = dictionaryDB.getDictionaryIds(user_id);
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

	public int[] getDictionaryIds() {
		return dictionary_ids;
	}

	public void setDictionaryIds(int[] dictionary_ids) {
		this.dictionary_ids = dictionary_ids;
	}

		
	

}
