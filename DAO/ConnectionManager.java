package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Singleton - klasa koju mozemo instancirati jednom
public class ConnectionManager {

	// instanca same klase
	private static ConnectionManager instance = null;

	// vrijednosti koje smo izabrali prilikom instalacije MySQL Servera
	private static final String USERNAME = "root";
	private static final String PASSWORD = "1234";
	// localhost//imeBazeNaKojuSeSpajamo
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/Imenik?useSSL=false&serverTimezone=UTC";

	// connection object
	private Connection conn = null;

	// privatni konstruktor - klasa moze biti instancirana samo unutar sebe
	private ConnectionManager() {

	}

	// provjeriti da li je instanca null, instancirati i vratiti ili samo vratiti
	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	private boolean openConnection() {
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	public Connection getConnection() {
		if (conn == null) {
			if (openConnection()) {
				System.out.println("Konekcija otvorena.");
				return conn;
			} else {
				return null;
			}
		}
		return conn;
	}

	public void close() {
		System.out.println("Konekcija zatvorena.");
		try {
			conn.close();
			conn= null;
		} catch (Exception e) {
		}
	}

}
