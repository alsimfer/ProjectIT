package objects;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import static util.UtilFunctions.*;
import db.*;

/**
 * This class represents the object from dictionary.user_dictionary db-entry.
 */
public class UserDictionary implements Serializable
{
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Word.class.getName());
	
	private int user_id;
	private int[] dictionary_ids;
	private DBQuery query;
	
	public UserDictionary(int user_id, int[] dictionary_ids) {
		super();
		this.user_id = user_id;
		this.dictionary_ids = dictionary_ids;
	}

	// Initialize related dictionary_ids for this user.
	public UserDictionary(int user_id)
	{		
		this.user_id = user_id;
		
		this.query = new DBQuery();
		this.dictionary_ids = query.getDictionaryIds(user_id);
		this.query.closeConnection();
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
