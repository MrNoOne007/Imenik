package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

import DTO.Korisnici;

public class Korisnik implements KorisnikDAOInterface {

// konekcija prema bazi
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public void addUser() throws SQLException {
		// Sql query
		String query = "Insert into User(username,password)values(?,?)";

		// Input
		Scanner input = new Scanner(System.in);
		System.out.print("Unesite username: ");
		String username = input.nextLine();
		System.out.println("Unesite password:");
		String password = input.nextLine();
		input.close();
		try (
				// java sql statement
			PreparedStatement Statement = (PreparedStatement) connection.prepareStatement(query);) {
			Statement.setString(1, username);
			Statement.setString(2, password);
			Statement.executeUpdate();
			System.out.println("User added to database!");
		}

	}
	@Override
	public String getUser(String username) throws SQLException {

		// null student
		Korisnici korisnik = null;
		String ime = "";
		String pass = "";

		String query = "SELECT * FROM User WHERE username = ?";

		ResultSet rs = null;

		try (

				PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);) {

			statement.setString(1, username);

			rs = statement.executeQuery();

			if (rs.next()) {

				ime = rs.getString("username");
				pass = rs.getString("password");

				rs.close();
			}
		}

		return ime + " " + pass;

	}
}


