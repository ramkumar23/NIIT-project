package config;
import java.sql.*;

public class Jdbcconnection {
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException
	
	
	{

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/PCSDB","root","");
		return conn;
	}

}