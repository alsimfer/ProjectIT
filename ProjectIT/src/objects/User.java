package objects;

import java.io.Serializable;

/**
 * User object.
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	protected int id, status;
	protected String firstName, lastName, email, password, language = "";
	
	public User() {
		this.id = 0;
		this.status = 0;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.password = "";
		this.language = "english";
	}
	
	public User(int id, int status, String firstName, String lastName,
			String email, String password, String language) {
		this.id = id;
		this.status = status;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.language = language;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
