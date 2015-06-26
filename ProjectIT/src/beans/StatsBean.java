package beans;

import static util.UtilFunctions.*;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;

import objects.*;
import controllers.*;

@ManagedBean
@RequestScoped
/** 
 * View: statistics.xhtml. 
 * Model: Stats.java.
 */
public class StatsBean implements Serializable {

	// Variables -------------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
	private ArrayList<StatEntry> stats = new ArrayList<StatEntry>();
	
    // Properties ------------------------------------------------------------------------------------------------------
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
    // Init ------------------------------------------------------------------------------------------------------------	
	@PostConstruct
	/**
	 * Get the stats for the logged user.
	 */
	public void init() {
		Stats statistics = new Stats(loginBean.getActiveUser().getId(), true);
		this.stats = statistics.getStats();
		
	}
	
    // Getters/setters ------------------------------------------------------------------------------------------------- 
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public ArrayList<StatEntry> getStats() {
		return stats;
	}

	public void setStats(ArrayList<StatEntry> stats) {
		this.stats = stats;
	}

}