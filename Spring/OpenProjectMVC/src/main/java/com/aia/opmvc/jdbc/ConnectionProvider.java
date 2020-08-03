package com.aia.opmvc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionProvider {

	
	public static Connection getConnection() throws SQLException {
	
		String jdbcUrl="jdbc:apache:commons:dbcp:pool";
	
		return DriverManager.getConnection(jdbcUrl);
	}
	
	
}
