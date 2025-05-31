package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	
	private static Connection con = null;
	static String user = "postgres";
	static String password = "admin";
	static String url = "jdbc:postgresql://localhost:5432/DB-luc";
	
	public static Connection getConnection(){
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, password);
			return con;
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
