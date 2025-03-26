package com.gsd.daw.prog.ApacheLogLoader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.gsd.daw.prog.ApacheAnalizer.FicheroRecoger;

public class App {
	
	public static void main(String[] args) throws IOException, SQLException {
		
	    // Comprobación de numero de argumentos
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
		
	    // Creacion de la conexión y comprobar ip
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
	    
	    //probar a conectarse con la bbdd
	    try (Connection conn = DriverManager.getConnection(url, user, contra)) {
			jdbcDemo(conn);
		} catch (SQLException e) {
			System.err.println("ERROR: excepción SQL: " + e.getMessage());
			return;
		}
		System.out.println( "INFO: conectado a BBDD." );
		
	    // Lectura de datos a estructuras planas y num de lineas leidas del fichero
		String [][] fichDatos= FicheroRecoger.SepararEnArray(logFile);
	    int numLineas = FicheroRecoger.contarLineas(logFile);
		System.out.println( "INFO: leidas [" + numLineas + "] lineas del fichero." );
		
	    // Conversion de estructuras planas a objetos del modelo
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
		//numero de lineas creadas en la lista y tiene que coincidir con el numero de lineas leidas del fichero
	    System.out.println( "INFO: creados [" + logsLista.size() + "] objetos del modelo." );
	    
	    // Guardado de los objetos del modelo en BBDD
	    // La clase del modelo debe tener un método save( Connection ) que recibe una
	    // conexion JDBC y hace que los datos del objeto se guarden en BBDD
	    Connection conn = DriverManager.getConnection(url, user, contra);
	    int filasInsertadas=0;
	    for (LineaLog l : logsLista) {
			l.save(conn);
			filasInsertadas++;
		}
	    System.out.println( "INFO: insertadas [" + filasInsertadas + "] filas en BBDD." );
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
