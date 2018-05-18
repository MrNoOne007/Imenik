package DAO;

import java.sql.SQLException;
import DTO.Korisnici;

public interface KorisnikDAOInterface {

	public void addUser() throws SQLException;

	public String getUser(String userName) throws SQLException;

}
