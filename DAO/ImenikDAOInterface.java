package DAO;

import java.sql.SQLException;


public interface ImenikDAOInterface {
// metoda za dodavanje korisnika
		
	public void add(String Korisnik) throws SQLException;
	
	//metoda za azuriranje

	public void edit(String Korisnik) throws SQLException;
	
	//metoda za brisanje korisnika

	public void delete( ) throws SQLException;
	
	// metoda za pregled korisnika

	public  void viewAll(String Korisnik) throws SQLException;

}
	
	

