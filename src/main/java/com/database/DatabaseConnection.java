package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private final static  String DRIVER_CLASS="oracle.jdbc.driver.OracleDriver"; 
	private final static  String URL="jdbc:oracle:thin:@localhost:1521:XE"; 
	private final static  String USER="system"; 
	private final static  String PASSWORD="system"; 
	private static boolean isDriverLoaded=false;
	static {
		try {
			Class.forName(DRIVER_CLASS);
		System.out.println("Driver Loaded Successfuly");
		isDriverLoaded =true;
	} catch (ClassNotFoundException e) {
		 System.out.println("drver "+e.getMessage());
	}
} 

public static Connection getConnection() throws SQLException {
	Connection con  =  null;
	if(isDriverLoaded) {
		con  = DriverManager.getConnection(URL, USER, PASSWORD);
	}
	return con;
}

public static void closeConnection(Connection con) throws SQLException {
  if(con!=null) {
	  con.close();
  }
}	
}
