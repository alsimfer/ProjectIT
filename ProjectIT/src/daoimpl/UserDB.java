package daoimpl;

import java.sql.Connection;

import db.DBQuery;
import objects.User;

public class UserDB extends DBQuery{
	
	public User getUserByEmailPassword(String email, String password) {
		String query = "SELECT * FROM user WHERE email = '" + email + "' AND password = '" + password + "'";
		int id, status;
		String firstName, lastName, language = "";
		User user = new User();
		Object [][] resultData;
		
		if(getDbc() != null) {
			Connection con = getDbc().connect();
			query(query, con);
			resultData = getResultData();
			
			if (resultData != null) {
				id = (int) (long)  resultData[0][0];
				lastName = (String) resultData[0][1];
				firstName = (String) resultData[0][2];
				language = (String) resultData[0][5];
				status = (int) resultData[0][6];
				
				user = new User(id, status, firstName, lastName, email, password, language);		
			} else {
				user = null;
			}
		closeConnection();
		}
		
		return user;
	}
	
	public User getUserByEmail(String email) {
		String query = "SELECT * FROM user WHERE email = '" + email + "';";
		int id, status;
		String firstName, lastName, language, password = "";
		User user = new User();
		Object [][] resultData;
		
		if(getDbc() != null) {
			Connection con = getDbc().connect();
			query(query, con);
			resultData = getResultData();
			
			if (resultData != null) {
				id = (int) (long)  resultData[0][0];
				lastName = (String) resultData[0][1];
				firstName = (String) resultData[0][2];
				password = (String) resultData[0][4];
				language = (String) resultData[0][5];
				status = (int) resultData[0][6];
				
				user = new User(id, status, firstName, lastName, email, password, language);		
			} else {
				user = null;
			}
		closeConnection();
		}
		
		return user;
	}	
	
	public int updateUserById(int id, String lastName, String firstName, String language, String password) {
		String query = "UPDATE user SET "
				+ "last_name = '" + lastName + "', "
				+ "first_name = '" + firstName + "', "
				+ "language = '" + language + "', "
				+ "password = '" + password + "' "
				+ " WHERE id = " + id;				
		if(getDbc() != null) {
			Connection con = getDbc().connect();
			query(query, con);
			closeConnection();
			return getUpdateResult();
		} else {
			return 0;
		}
	}	
	
	public int addUser(String lastname, String firstName, String email, String password, String language) {
		String query = "INSERT INTO user ("
				+ "`id`, "
				+ "`last_name`, "
				+ "`first_name`, "
				+ "`email`, "
				+ "`password`, "
				+ "`language`, "
				+ "`status`"
				+ ") VALUES ("
				+ "DEFAULT, "
				+ "'" + lastname + "', "
				+ "'" + firstName + "', "
				+ "'" + email + "', "
				+ "'" + password + "', "
				+ "'" + language + "', "
				+ "1)";				
		
		if(getDbc() != null) {
			Connection con = getDbc().connect();
			query(query, con);	
			closeConnection();
			return getUpdateResult();
		} else {
			return 0;
		}
	}

}
