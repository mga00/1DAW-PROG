package com.luisantolin.daw.prog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	public static void main( String[] args ) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "user", "changeme");
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM prueba_tb");
			while (resultSet.next()) {
				System.out.print( "Nombre: " + resultSet.getString("nombre") );
				System.out.print( " Email: " + resultSet.getString("email") + "\n");
			}
			resultSet.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.err.println("ERROR: " + e.getMessage());
		}

	}
}
