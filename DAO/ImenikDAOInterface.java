package DAO;
	import java.sql.SQLException;

public interface ImenikDAOInterface {

// metoda za dodavanje korisnika
		
	public void add(Korisnik korisnik) throws SQLException;
	
	//metoda za azuriranje

	public void edit(Korisnik korisnik) throws SQLException;
	
	//metoda za brisanje korisnika

	public void delete( ) throws SQLException;
	
	// metoda za pregled korisnika

	public  void viewAll(Korisnik korisnik) throws SQLException;

	void viewAll(String Korisnik) throws SQLException;

	void add(String Korisnik) throws SQLException;

	void edit(String korisnik) throws SQLException;

}
	
	
	
	
	
	
	
	
	

