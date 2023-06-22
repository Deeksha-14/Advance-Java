package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection cn;
	
	public static Connection openConnection() throws SQLException
	{System.out.println("in open connection");
		String dburl="jdbc:mysql://localhost:3306/advjava?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		cn = DriverManager.getConnection(dburl, "root", "root123");
		return cn;
	}

	
	public static void closeConnection() throws SQLException
	{
		if(cn!=null)
			cn.close();
		System.out.println("Connection closed");
	}
}
