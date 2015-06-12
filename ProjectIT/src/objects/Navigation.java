package objects;

import java.io.Serializable;
import java.util.ArrayList;

import db.*;

public class Navigation implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	ArrayList<Page> navigation = new ArrayList<Page>();
	private DBQuery query;
	
	public Navigation()
	{		
		this.query = new DBQuery();
		this.navigation = query.getNavigation();
		this.query.closeConnection();
	}

	public ArrayList<Page> getNavigation() {
		return navigation;
	}

	public void setNavigation(ArrayList<Page> navigation) {
		this.navigation = navigation;
	}
		
	
}
