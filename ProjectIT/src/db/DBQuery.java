package db;

import static util.UtilFunctions.*;

import java.math.BigInteger;
import java.util.ArrayList;

import objects.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class DBQuery {

	private DBConnection dbc;
	//------------------------------------------------- Constructor -------------------------------------------------
	public DBQuery() 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext exContext = context.getExternalContext();
		String dbName = new String("");
		String dbURL = new String("");
		String dbUser = new String("");
		String dbPassword = new String("");
		try {
			dbName = exContext.getInitParameter("dbName");
			dbURL = exContext.getInitParameter("dbURL");
			dbUser = exContext.getInitParameter("dbUser");
			dbPassword = exContext.getInitParameter("dbPassword");
		}
		catch (Exception e) { 
			p("Can not get servlet context params for a DB connection."); 
		}
		
		this.dbc = new DBConnection(dbName, dbURL, dbUser, dbPassword);
		
		int message = this.dbc.connect();			
		// Check the status of the connection to the DB.
		if (message == -1) {
			p("The login data is not correct or the database connection is shut down.");
		} else if (message == -2) {
			p("The driver could not be loaded.");
		}	
	}
	
	//-------------------------------------------------- Navigation -------------------------------------------------
	public ArrayList<Page> getNavigation() {
		
		String query = "SELECT"
				+ "	id,"
				+ " slug,"
				+ " title_en,"
				+ " link_en,"
				+ " content_en,"
				+ " title_de,"
				+ " link_de,"
				+ " content_de,"
				+ " title_ru,"
				+ " link_ru,"
				+ " content_ru"
				+ " FROM navigation";
		int id;
		String slug, title_en, link_en, content_en, title_de, link_de, content_de, title_ru, link_ru, content_ru = "";
		Object [][] resultData;
		ArrayList<Page> navigation = new ArrayList<Page> ();
		
		this.dbc.query(query);
		resultData = this.dbc.getResultData();		
		for (int i = 0; i < resultData.length; i++) {
			id = (int) (long)  resultData[i][0];
			slug = (String) resultData[i][1];
			title_en = (String) resultData[i][2];
			link_en = (String) resultData[i][3];
			content_en = (String) resultData[i][4];
			title_de = (String) resultData[i][5];
			link_de = (String) resultData[i][6];
			content_de = (String) resultData[i][7];
			title_ru = (String) resultData[i][8];
			link_ru = (String) resultData[i][9];
			content_ru = (String) resultData[i][10];
			
			Page page = new Page(id, slug, title_en, link_en, content_en, title_de, link_de, content_de, title_ru, link_ru, content_ru);
			navigation.add(page);
		}
		
		return navigation;
	}		
	
	
	public String getSlugById(int id) {
		String query = "SELECT" 
				+ " slug"
				+ " FROM navigation"
				+ " WHERE id = " + id;
		
		String slug = "";
		Object [][] resultData;
		
		this.dbc.query(query);
		resultData = this.dbc.getResultData();
		
		slug = (String) resultData[0][0];
		
		return slug;
	}	
	
	//-------------------------------------------------- User -------------------------------------------------
	public User getUserByEmailPassword(String email, String password) {
		String query = "SELECT * FROM user WHERE email = '" + email + "' AND password = '" + password + "'";
		int id, status;
		String firstName, lastName, language = "";
		User user;
		Object [][] resultData;
		
		this.dbc.query(query);
		resultData = this.dbc.getResultData();
		
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
		
		return user;
	}	
	
	public int updateUserById(int id, String lastName, String firstName, String language) {
		String query = "UPDATE user SET "
				+ "last_name = '" + lastName + "', "
				+ "first_name = '" + firstName + "', "
				+ "language = '" + language + "' "
				+ " WHERE id = " + id;				

		this.dbc.query(query);
						
		return this.dbc.getUpdateResult();
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

		this.dbc.query(query);
						
		return this.dbc.getUpdateResult();
	}	
	
	
	//-------------------------------------------------- Connection -------------------------------------------------
	public void closeConnection()
	{
		this.dbc.disconnect();
	}
}
