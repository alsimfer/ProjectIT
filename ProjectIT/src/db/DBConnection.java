package db;

import java.sql.*;

import static util.UtilFunctions.*;

/**
 * Diese Klasse ist für die Datenbank-Kommunikation verantwortlich.
 *
 */

public class DBConnection {
	 
	private String db;
	private String url;
	private String user;
	private String password;

	private Driver drv = null;
	private Connection con = null;
    
    private boolean driverLoaded = false;
    
    public DBConnection(String db, String url, String user, String password)
    {    	
    	this.db = db;
    	this.url = url;
    	this.user = user;
    	this.password = password;
    	this.loadDriver();
    }
    
    public void loadDriver()
    {
    	try {    
        	if (this.db.equals("mySQL")) {
        		this.drv = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance(); 
        		this.driverLoaded = true;
        	} else if (this.db.equals("postgreSQL")) {
        		this.drv = (Driver)Class.forName("org.postgresql.Driver").newInstance();
        		this.driverLoaded = true;
        	}
    	} catch (Exception e) {
    		this.driverLoaded = false;
    	}    	    	
    }

    public Connection connect()
    {   
    	this.con = null;
    	if (this.driverLoaded == true) {
    		try {
    			this.con = DriverManager.getConnection(this.url, this.user, this.password);
    		}
    		catch (SQLException e) {
    			p("The login data is not correct or the database connection is shut down.");
    		}
    	} else {   
    		p("The driver could not be loaded.");
    	}
    	return this.con;
    }
    
    public void disconnect()
    {
    	try {
			this.con.close();
		} catch (SQLException e) {
			System.out.println("An error occured while disconnecting.\n" + e.toString());
		}
    }
    
}