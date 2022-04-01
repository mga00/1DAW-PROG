package com.luisantolin.daw.prog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * CREACION DE LA BBDD, DEL USUARIO Y PERMISOS
 * 
 * create database testdb;
 * CREATE USER 'lantolin'@'%' IDENTIFIED BY 'changeme';
 * GRANT ALL PRIVILEGES ON testdb.* TO 'lantolin'@'%';
 */

public class App {
	public static void main( String[] args ) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://lantolin.daw.practicas.net:3306/testdb?serverTimezone=UTC", "lantolin", "changeme");
			Statement stmt = con.createStatement();
//			ResultSet resultSet = stmt.executeQuery("SELECT * FROM prueba_tb");
			ResultSet resultSet = stmt.executeQuery("SELECT sysdate() as fecha FROM dual");
			while (resultSet.next()) {
				System.out.print( "Fecha: " + resultSet.getString("fecha") );
//				System.out.print( "Nombre: " + resultSet.getString("nombre") );
//				System.out.print( " Email: " + resultSet.getString("email") + "\n");
			}
			resultSet.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.err.println("MANAZAS: " + e.getMessage());
		}

	}
}
