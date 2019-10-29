package com.icecreamparlour.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionHelper {
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databaseName=IceCreamParlour;username=sa;password=sunlife_1234");
		}
		catch(ClassNotFoundException|SQLException exception){
			exception.printStackTrace();
		}
		return connection;
	}
}
