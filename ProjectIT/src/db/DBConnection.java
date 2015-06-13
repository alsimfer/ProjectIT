package db;

import java.sql.*;
import java.util.*;
import static util.UtilFunctions.*;

public class DBConnection {
	 
	private String db;
	private String url;
	private String user;
	private String password;
	private int updateResult;
	private String[] columnNames;
	private Object[][] resultData;

	private Driver drv = null;
	private Connection con = null;
	private ResultSet result = null;
	private ResultSetMetaData meta = null;
    
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

    public int connect()
    {        	
    	if (this.driverLoaded == true) {
    		try {
    			this.con = DriverManager.getConnection(this.url, this.user, this.password);
//    			System.out.println("DB connection was opened.");
    			return 1;
    		}
    		catch (SQLException e) {
    			return -1;
    		}
    	}   
    	return -2;
    }
    
    public void disconnect()
    {
    	try {
			this.con.close();
//			System.out.println("DB connection was closed.");
		} catch (SQLException e) {
			System.out.println("An error occured while disconnecting.\n" + e.toString());
		}
    }
    
    public void query(String queryString) 
    {   	    	    	
    	try {
    		Statement stmt;
    		stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    		
    		boolean rc = stmt.execute(queryString);
    		
    		if (rc == true) {
    			this.result = stmt.getResultSet();
    			if (this.result != null) {
    				this.getResult();    				
    			} else {    		    	
    		    	System.out.println("The result is empty");
    			}
    		} else {
    			int amount = stmt.getUpdateCount();
//    			System.out.println(amount + " rows were updated");
    			this.updateResult = amount;
    		}
    	} catch (SQLException e) {
    		System.out.println("The query " + queryString + " could not be processed\n" + e.toString());
    	}
    }
    
    public void getResult() {
    	int columnsAmount = 0;
    	int rowsAmount = 0;
    	
    	try {
    		while (this.result.next()) {
    			rowsAmount++;
    		}
    		
    		this.meta = this.result.getMetaData();
    		columnsAmount = meta.getColumnCount();
    		
    		this.columnNames = new String[columnsAmount];
    		
    		// Get the column names.
    		for (int i = 0; i < columnsAmount; i++) {
    			this.columnNames[i] = meta.getColumnLabel(i+1);    			
    		}
    		
    		// Get the table data.
    		this.resultData = new Object[rowsAmount][columnsAmount];
    		for (int i = 0; i < rowsAmount; i++) {
    			this.result.absolute(i+1);
    			for (int j = 0; j < columnsAmount; j++) {
    				this.resultData[i][j] = this.result.getObject(j+1);
    			}
    		}
    		
    		if (rowsAmount == 0) {
//    			System.out.println("No data found");
    			this.resultData = null;
    		}
    		
//    		System.out.println("The resultSet was successfully evaluated");
    	} catch (SQLException e) {
    		System.out.println("Can not evaluate the ResultSet\n" + e.toString());
    	}    	    	
    	
    }
    
    public String [] getColumnNames() 
    {
    	return this.columnNames;
    }
    
    public Object [][] getResultData() 
    {
    	return this.resultData;
    }    
    
    public ResultSet getResultSet()
    {
    	return this.result;
    }
    
    public int getUpdateResult() 
    {
    	return this.updateResult;
    }
    
    public int getRowCount(ResultSet resultSet)
    {
        if (resultSet == null) {
            return 0;
        }
        try {
            resultSet.last();
            return resultSet.getRow();
        } catch (SQLException exp) {
            exp.printStackTrace();
        } finally {
            try {
                resultSet.beforeFirst();
            } catch (SQLException exp) {
                exp.printStackTrace();
            }
        }
        return 0;
    }
    
}