package com.luisantolin.daw.prog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ejemplo de uso de JDBC con dos SGBD. La idea es darse cuenta de que un codigo bien escrito usando solo las funcionalidades
 * estandar de JDBC hace que las diferencias en código entre usar ORACLE y MySQL sean minimas, solo el connect-string y las
 * dependencias Maven
 * Si te das cuenta, el código JAVA/SQL que se ejecuta (jdbcDemo) es exactamente el mismo para ORACLE y MySQL.
 * 
 * @author lantolin
 */
public class App {
    public static void main( String[] args ) {
        try {
            System.out.println( "ORACLE" );
            Connection conn1 = DriverManager.getConnection( "jdbc:oracle:thin:@//127.0.0.1/XEPDB1", "lantolin", "changeme" );
            jdbcDemo( conn1 );
            System.out.println( "MySQL" );
            Connection conn2 = DriverManager.getConnection( "jdbc:mysql://127.0.0.1:3306/testdb?serverTimezone=UTC", "lantolin", "changeme" );
            jdbcDemo( conn2 );
        } catch ( SQLException e ) {
            System.err.println( "Las BBDD no son lo tuyo: " + e.getMessage() );
        }
    }

    private static void jdbcDemo( Connection conn ) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery( "SELECT * FROM prueba_tb" );
        while ( resultSet.next() ) {
            System.out.print( "Nombre: " + resultSet.getString( "nombre" ) );
            System.out.print( " Email: " + resultSet.getString( "email" ) + "\n" );
        }
        resultSet.close();
        stmt.close();
        conn.close();
    }
}
