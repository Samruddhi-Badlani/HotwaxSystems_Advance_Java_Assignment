package com.customerRegistration;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	static Connection con ;

	

		public static Connection createConnection() {
			
			// load the driver
			
			
			
			try {
			Class.forName("org.postgresql.Driver");
			
			
			
			String JdbcURL = "jdbc:postgresql://localhost:5432/advance_java";
		    String Username = "postgres";
		    String password = "abc1234";
		    
		    con=DriverManager.getConnection(JdbcURL, Username, password);
			}
			catch (Exception e) {
				// TODO: handle exception
				
				e.printStackTrace();
			}
			
			return con;
	}
}
