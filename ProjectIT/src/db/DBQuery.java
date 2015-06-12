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
				+ " title,"
				+ " link,"
				+ " content,"
				+ " title_de,"
				+ " link_de,"
				+ " content_de,"
				+ " title_ru,"
				+ " link_ru,"
				+ " content_ru"
				+ " FROM navigation";
		int id;
		String slug, title, link, content, title_de, link_de, content_de, title_ru, link_ru, content_ru = "";
		Object [][] resultData;
		ArrayList<Page> navigation = new ArrayList<Page> ();
		
		this.dbc.query(query);
		resultData = this.dbc.getResultData();		
		for (int i = 0; i < resultData.length; i++) {
			id = (int) (long)  resultData[i][0];
			slug = (String) resultData[i][1];
			title = (String) resultData[i][2];
			link = (String) resultData[i][3];
			content = (String) resultData[i][4];
			title_de = (String) resultData[i][5];
			link_de = (String) resultData[i][6];
			content_de = (String) resultData[i][7];
			title_ru = (String) resultData[i][8];
			link_ru = (String) resultData[i][9];
			content_ru = (String) resultData[i][10];
			
			Page page = new Page(id, slug, title, link, content, title_de, link_de, content_de, title_ru, link_ru, content_ru);
			navigation.add(page);
		}
		
		return navigation;
	}		
	
	
	public String getSlugByID(int id) {
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
	
	
	public void closeConnection()
	{
		this.dbc.disconnect();
	}
}
