package DTO;

public class Korisnici {
	// data fields

	private String userName;
	private String password;

	public Korisnici() {

	}

	public Korisnici(int userID, String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
