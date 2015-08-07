package daoimpl;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;

import db.DBQuery;
import objects.Page;

/**
 * Klasse NavigationDB ist für den Zugriff auf die Daten aus der Tabelle navigation im DB zuständig.
 * Holt die aktuellen Daten aus der Tabelle im DB.
 * 
 */

public class NavigationDB extends DBQuery implements Serializable {

	private static final long serialVersionUID = 1L;

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
		
		if(getDbc() != null) {
			Connection con = getDbc().connect();
		
			query(query, con);
			resultData = getResultData();	
			if(resultData != null) {
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
			}
		closeConnection();
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
		
		if(getDbc() != null) {
			Connection con = getDbc().connect();
			
			query(query, con);
			resultData = getResultData();
			
			if(resultData != null) {
				slug = (String) resultData[0][0];
			}
		closeConnection();
		}
		return slug;
	}	
	
	
}
