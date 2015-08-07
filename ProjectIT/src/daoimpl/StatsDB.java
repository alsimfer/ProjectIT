package daoimpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import db.DBQuery;
import objects.*;
import static util.UtilFunctions.*;

/**
 * Klasse StatsDB ist für den Zugriff auf die Daten aus der Tabelle stats im DB zuständig.
 *
 */

public class StatsDB extends DBQuery{
	
	public ArrayList<StatEntry> getStatsByUserId(int userId, boolean groupByDate) {
		String query = "SELECT "
				+ "id, "
				+ "date, "
				+ "SUM(total_guessed) AS total_guessed, "
				+ "SUM(total_answered) AS total_answered "
				+ "FROM stats "
				+ "WHERE user_id = " + userId + " "
				+ "GROUP BY user_id";
		
		if (groupByDate == true) {
			query += ", date";
		}
		
		int id, totalGuessed, totalAnswered;
		BigDecimal bd;
		Date date;
		
		ArrayList<StatEntry> stats = new ArrayList<StatEntry>();
		
		Object [][] resultData;
		
		if(getDbc() != null) {
			Connection con = getDbc().connect();
			query(query, con);
			resultData = getResultData();
			
			if (resultData != null) {
				for (int i = 0; i < resultData.length; i++) {
					id = (int) (long)  resultData[i][0];
					date = (Date) resultData[i][1];
					bd = (BigDecimal) resultData[i][2];
					totalGuessed = bd.intValue();
					bd = (BigDecimal) resultData[i][3];
					totalAnswered = bd.intValue();
					
					String dateString = date2String(date);
					stats.add(new StatEntry(id, userId, totalGuessed, totalAnswered, dateString));
				}
			} else {
				stats = null;
			}
		closeConnection();
		}
		
		return stats;
	}	
	
	public int addStats(int userId, String date, int totalGuessed, int totalAnswered, String langQ, String langA) {
		// Check if the user already passed some tests today.
		String query = "INSERT INTO stats ("
				+ "`id`, "
				+ "`user_id`, "
				+ "`date`, "
				+ "`total_guessed`, "
				+ "`total_answered`, "
				+ "`question_language`, "
				+ "`answer_language`"
				+ ") VALUES ("
				+ "DEFAULT, "
				+ "'" + userId + "', "
				+ "'" + date + "', "
				+ "'" + totalGuessed + "', "
				+ "'" + totalAnswered + "', "
				+ "'" + langQ + "', "
				+ "'" + langA + "'"
				+ ")";				
		
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
