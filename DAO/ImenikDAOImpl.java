package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.sql.PreparedStatement;
import DTO.Imenik;
import DTO.Korisnici;

public class ImenikDAOImpl implements ImenikDAOInterface {
	// konekcija prema bazi

	Connection connection = ConnectionManager.getInstance().getConnection();

	// Unos
	@Override
	public void delete() throws SQLException {

		String query = "Delete from Imenik.Imena where Ime=?";
		Scanner input = new Scanner(System.in);
		System.out.print("Unesite ime korisnika kojeg zelite da obrisete: ");
		String ime = input.nextLine();
		input.close();
		try (PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);) {
			statement.setString(1, ime);
			statement.executeUpdate();
			System.out.println("Uspjensno ste izbrisali korisnika! ");

		}
	}

	@Override
	public void add(Korisnik korisnik) throws SQLException {
		// sql query
		String query = "Insert into Imenik.Imena (Ime, Prezime, Mail, phoneNUM) values (?, ?, ?, ?)";

		// unos podataka
		Scanner input = new Scanner(System.in);
		System.out.print("Unesite ime: ");
		String ime = input.nextLine();
		System.out.println("Unesite prezime:");
		String prezime = input.nextLine();
		System.out.println("Molimo unesite vas email: ");
		String Mail = input.nextLine();
		System.out.println("Unesite broj telefona: ");
		String phoneNum = input.nextLine();
		input.close();
		try (
				// java sql statement
				PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);) {
			statement.setString(1, ime);
			statement.setString(2, prezime);
			statement.setString(3, Mail);
			statement.setString(4, phoneNum);
			statement.executeUpdate();
			System.out.println("Uspjesno ste unijeli sve podatke! ");
		}

	}

	@Override
	public void edit(Korisnik korisnik) throws SQLException {
		Scanner input = new Scanner(System.in);
		System.out.println("Unesite ime koje zelite azurirati: ");
		String imeStaro = input.nextLine();
		System.out.println("Unesite prezime koje zelite azurirati: ");
		String prezStaro = input.nextLine();
		System.out.print("Unesite novo ime: ");
		String imeNovo = input.nextLine();
		System.out.print("Unesite novo prezime: ");
		String prezimeNovo = input.nextLine();
		input.close();
		String query = "Update Imenik.Imena SET Ime=? and Prezime=? where (Ime=?,Prezime=?)";
		try (PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);) {
			statement.setString(1, imeNovo);
			statement.setString(2, prezimeNovo);
			statement.setString(3, imeStaro);
			statement.setString(4, prezStaro);
			statement.executeUpdate();
			System.out.println("Uspjesno se azurirali! ");
		}
	}

	@Override
	public void viewAll(Korisnik korisnik) throws SQLException {
		// TODO Auto-generated method stub

	}

	

	@Override
	public void edit(String korisnik) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(String Korisnik) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewAll(String Korisnik) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
