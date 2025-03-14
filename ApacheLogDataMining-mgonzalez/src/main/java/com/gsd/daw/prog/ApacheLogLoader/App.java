package com.gsd.daw.prog.ApacheLogLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gsd.daw.prog.ApacheAnalizer.FicheroRecoger;

public class App {
	
	public static void main(String[] args) throws IOException, SQLException {
	    // Comprobación de argumentos
		if(args.length>5) {
			System.err.println("Error: Has puesto demasiados argumentos.");
			return;
		}
		if(args.length<5) {
			int argsNum=5-args.length;
			if (argsNum==1) {
				System.err.println("Error: Te falta "+argsNum+" dato: ");
			}else
				System.err.println("Error: Te faltan "+argsNum+" datos: ");
		}
	    // Creacion de la conexión
		String ip=args[0];
		if (!CompArgs.compIp(ip)) {
			System.err.println("Error: La ip no es correcta");
			return;
		}
		String nombre=args[1];
		
		String url="jdbc:oracle:thin:@//"+ip+"/"+nombre;
	    String user=args[2];
	    
	    String contra=args[3];
	    
	    String logFile=args[4];
	    
	    try (Connection conn = DriverManager.getConnection(url, user, contra)) {
			jdbcDemo(conn);
		} catch (SQLException e) {
			System.err.println("ERROR: excepción SQL: " + e.getMessage());
			return;
		}
		System.out.println( "INFO: conectado a BBDD." );
	    // Lectura de datos a estructuras planas
		String [][] fichDatos= FicheroRecoger.SepararEnArray(logFile);
	    int numLineas = FicheroRecoger.contarLineas(logFile);
		System.out.println( "INFO: leidas [" + numLineas + "] lineas del fichero." );
	    // Conversion de estructuras planas a objetos del modelo
		// Crea una clase que modele los datos que tiene una linea de log de Apache
		// Convierte la estructura "anónima" en un array de objetos del modelo
		List<LineaLog> logsLista = new ArrayList<>();
		for (int i = 0; i < fichDatos.length; i++) {
			if(fichDatos[i][0]==null) {
				break;
			}
			LineaLog l =new LineaLog(fichDatos[i][0], fichDatos[i][1], fichDatos[i][2], fichDatos[i][3],
					fichDatos[i][4], fichDatos[i][5]);
			logsLista.add(l);
		}
	    System.out.println( "INFO: creados [" + logsLista.size() + "] objetos del modelo." );
	    // Guardado de los objetos del modelo en BBDD
	    // La clase del modelo debe tener un método save( Connection ) que recibe una
	    // conexion JDBC y hace que los datos del objeto se guarden en BBDD
	    Connection conn = DriverManager.getConnection(url, user, contra);
	    for (LineaLog l : logsLista) {
			l.save(conn);
		}
	    //System.out.println( "INFO: insertadas [" + i + "] filas en BBDD." );
	}
	private static void jdbcDemo(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		conn.setAutoCommit(true);
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM APACHE_LOG_TBL");
		while (resultSet.next()) {
		}
		resultSet.close();
		stmt.close();
		conn.close();
	}
}
