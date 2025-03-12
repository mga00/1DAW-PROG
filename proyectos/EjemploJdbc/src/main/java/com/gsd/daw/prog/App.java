package com.gsd.daw.prog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ejemplo de uso de JDBC con varios SGBD y de Variables de Entorno.
 * Aprovechamos este ejemplo para introducir también el uso de variables de
 * entorno. El programa decidirá si funciona con ORACLE o MySQL dependiendo
 * del valor de una variable de entorno.
 * La idea es darse cuenta de que un codigo bien escrito usando solo las
 * funcionalidades
 * estandar de JDBC hace que las diferencias en código entre usar ORACLE y MySQL
 * sean minimas, solo el connect-string y las
 * dependencias Maven
 * Si te das cuenta, el código JAVA/SQL que se ejecuta (jdbcDemo) es exactamente
 * el mismo para ORACLE y MySQL.
 * 
 * @author lantolin
 */
public class App {
	/**
	 * Valor de la variable de entorno SGBD para que se use MySQL
	 */
	public static final String SGBD_MYSQL = "MYSQL";
	/**
	 * Valor de la variable de entorno SGBD para que se use Oracle
	 */
	public static final String SGBD_ORACLE = "ORACLE";
	/**
	 * Valor de la variable de entorno SGBD para que se use PostgreSQL
	 */
	public static final String SGBD_POSTGRESQL = "POSTGRESQL";

	/**
	 * Punto de entrada de la aplicacion
	 * @param args no se recibe ni procesa ningún argumento
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		String connectionString = "";

		String mySgbd = System.getenv("SGBD");//getenv=get enviroment (entorno)
		if (mySgbd == null) {
			System.err.println("WARN: Variable SGBD no configurada, se asume mySQL");
			mySgbd = SGBD_MYSQL;
		}
		switch (mySgbd) {
		case SGBD_POSTGRESQL:
			connectionString = "jdbc:postgresql://127.0.0.1/test_db";
			break;
		case SGBD_ORACLE:
			connectionString = "jdbc:oracle:thin:@//127.0.0.1/XEPDB1";
			break;
		case SGBD_MYSQL:
			connectionString = "jdbc:mysql://127.0.0.1:3306/testdb?serverTimezone=UTC";
			break;
		default:
			connectionString = "jdbc:mysql://127.0.0.1:3306/testdb?serverTimezone=UTC";
			break;
		}

		System.out.println(mySgbd);
		try (Connection conn = DriverManager.getConnection(connectionString, "test", "changeme")) {
			jdbcDemo(conn);
		} catch (SQLException e) {
			System.err.println("ERROR: excepción SQL: " + e.getMessage());
			return;
		}
	}

	private static void jdbcDemo(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM prueba_tb");
		while (resultSet.next()) {
			System.out.print("Nombre: " + resultSet.getString("nombre"));
			System.out.print(" Email: " + resultSet.getString("email") + "\n");
		}
		resultSet.close();
		stmt.close();
		conn.close();
	}
}
