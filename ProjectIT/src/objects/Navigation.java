package objects;

import java.io.Serializable;
import java.util.ArrayList;

import daoimpl.NavigationDB;
import db.*;
import static util.UtilFunctions.*;

public class Navigation implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	ArrayList<Page> navigation = new ArrayList<Page>();
	private NavigationDB navigationDB;
	
	public Navigation()
	{	
		this.navigationDB = new NavigationDB();
		this.navigation = navigationDB.getNavigation();
	}

	public ArrayList<Page> getNavigation() {
		return navigation;
	}
	
	public void setNavigation(ArrayList<Page> navigation) {
		this.navigation = navigation;
	}
	
	public Page getPageById(int id) {
		Page returnPage = new Page();
		for (Page page: this.navigation) {
			if (page.getId() == id) {
				return page;
			}
		}
		
		return returnPage;
	}
}
