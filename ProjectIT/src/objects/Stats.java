package objects;

import java.io.Serializable;
import java.util.ArrayList;
import daoimpl.StatsDB;

/**
 * This is the Statistics object. Contains StatEntries for ActiveUser as ArrayList.
 */
public class Stats implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<StatEntry> stats = new ArrayList<StatEntry>(); 
	private StatsDB statsDB;
	
	public Stats() {
		super();		
	}
	
	public Stats(int userId, boolean groupByDate) {
		super();
		statsDB = new StatsDB();
		this.stats = statsDB.getStatsByUserId(userId, groupByDate);		
	}

	public ArrayList<StatEntry> getStats() {
		return stats;
	}

	public void setStats(ArrayList<StatEntry> stats) {
		this.stats = stats;
	}
	
}
