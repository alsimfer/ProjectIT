package db;

import static util.UtilFunctions.*;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objects.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class DBQuery {

	private DBConnection dbc;
	
	private int updateResult;
	private String[] columnNames;
	private Object[][] resultData;
	private ResultSet result = null;
	private ResultSetMetaData meta = null;
	
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
	}
	
	//------------------------------------------------- Query -------------------------------------------------
	public void query(String queryString, Connection con) 
    {   	    	    	
    	try {
    		Statement stmt;
    		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    		
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
    			this.resultData = null;
    		}
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
	
	//-------------------------------------------------- Connection -------------------------------------------------
	
	public void closeConnection()
	{
		this.dbc.disconnect();
	}

	public DBConnection getDbc() {
		return dbc;
	}

	public void setDbc(DBConnection dbc) {
		this.dbc = dbc;
	}
}
