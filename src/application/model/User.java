package application.model;

/**
 * 
 * @author lucadebeir
 *
 */

public class User {
	
	private int idUser = 0;
	private String lastNameUser = "";
	private String firstNameUser = "";
	private String email = "";
	private String password = "";
	
	
	public User(int idUser, String lastNameUser, String firstNameUser, 
			String email, String password) {
		this.idUser = idUser;
		this.lastNameUser = lastNameUser;
		this.firstNameUser = firstNameUser;
		this.email = email;
		this.password = password;
	}
	
	
	public int getId() {
		return idUser;
	}
	public void setId(int id) {
		this.idUser = id;
	}
	public String getLastNameUser() {
		return lastNameUser;
	}
	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}
	public String getFirstNameUser() {
		return firstNameUser;
	}
	public void setFirstNameUser(String firstNameUser) {
		this.firstNameUser = firstNameUser;
	}
	public String getEmailUser() {
		return email;
	}
	public void setEmailUser(String email) {
		this.email = email;
	}
	public String getPasswordUser() {
		return password;
	}
	public void setPasswordUser(String password) {
		this.password = password;
	}

}
