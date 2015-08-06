package objects;

import static util.UtilFunctions.*;

import java.io.Serializable;

/**
 * This is the Statisticsentry object.
 */
public class StatEntry implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id, userId, totalGuessed, totalAnswered;
	private String date;
	private double rate; 
	
	public StatEntry() {
		super();
		this.id = 0;
		this.userId = 0;
		this.totalGuessed = 0;
		this.totalAnswered = 0;
		this.date = "";
		this.rate = 0;
	}
	
	public StatEntry(int id, int userId, int totalGuessed,
			int totalAnswered, String date) {
		super();
		this.id = id;
		this.userId = userId;
		this.totalGuessed = totalGuessed;
		this.totalAnswered = totalAnswered;
		this.date = date;
		this.rate = formatDecimal(((double) totalGuessed) / totalAnswered, 2);		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTotalGuessed() {
		return totalGuessed;
	}

	public void setTotalGuessed(int totalGuessed) {
		this.totalGuessed = totalGuessed;
	}

	public int getTotalAnswered() {
		return totalAnswered;
	}

	public void setTotalAnswered(int totalAnswered) {
		this.totalAnswered = totalAnswered;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
}
