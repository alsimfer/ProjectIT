package controllers;

import static util.UtilFunctions.*;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import objects.*;

// This class describes controllers. Naming conventions are here.
public abstract class Controller implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// This function processes clickEvents.
	public void getClickResult() {}
	
}
