package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	public static final String driver = "com.mysql.cj.jdbc.Driver" ;
	public static Connection conn;
	public static final String url ="jdbc:mysql://localhost:3306/IMS_Project";
	public static final String username="root";
	public static final String password="Abhi@911";
	
	// connection provider method
	public static Connection getCon()
	{
		try {
			Class.forName(driver);
			conn =DriverManager.getConnection(url,username,password);
                        System.out.println("Connection Build Succesfully");
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}
	
	// main method
	public static void main(String[] args){
		Conn.getCon();
	}
}
