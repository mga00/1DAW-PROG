package com.gsd.daw.prog.ApacheLogLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
	
	public static void main(String[] args) {
	    // Comprobación de argumentos
		if(args.length>5) {
			System.err.println("Error: Has puesto demasiados argumentos.");
			return;
		}
		if(args.length<5) {
			int argsNum=5-args.length;
			if (argsNum==1) {
				System.err.println("Error: Te falta "+argsNum+" dato");
				return;
			}
			System.err.println("Error: Te faltan "+argsNum+" datos");
			return;
		}
	    // Creacion de la conexión
		String ip=args[0];
		if (!ipRangosBien(ip)) {
			System.err.println("La ip no es correcta");
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
		final String LOG_REGEX="%h %l %u %u %t .\"%r\" %-s %b .\"%-Referer-i\" \"%-User-age-i\"";
	    final Pattern patt=Pattern.compile(LOG_REGEX);
	    try (Connection conn = DriverManager.getConnection(url, user, contra); 
	    		BufferedReader reader = new BufferedReader(new FileReader(logFile))){
	    	String line;
	    	while ((line=reader.readLine())!=null)  {
				Matcher matcher = patt.matcher(line);
				if (matcher.matches()) {
					String ip1=matcher.group(1);
					String logTime=matcher.group(2);
					String request=matcher.group(3);
					int result=Integer.parseInt(matcher.group(4));
					int bytesNumber=matcher.group(5).equals("-") ? 0 : Integer.parseInt(matcher.group(5));
					String userAgent= matcher.group(6);
					
					insertIntoDataBase(conn, ip1, logTime, request, result, bytesNumber, userAgent);
				}
				
			}
		} catch (Exception e) {
			System.err.println("Error al intentar leer el fichero");
		}
		// Esto sin colecciones será un String[][] array de tamaño máximo 40000
	    // elementos
	    // Crea una clase aparte, cuya responsabilidad sea recibir un nombre de fichero
	    // y devolver una estructura String[40000][6] con los datos en columnas
	    //System.out.println( "INFO: leidas [" + ponTuVariableAqui + "] lineas del fichero." );
	    // Conversion de estructuras planas a objetos del modelo
	    // Crea una clase que modele los datos que tiene una linea de log de Apache
	    // Convierte la estructura "anónima" en un array de objetos del modelo
	    //System.out.println( "INFO: creados [" + ponTuVariableAqui + "] objetos del modelo." );
	    // Guardado de los objetos del modelo en BBDD
	    // La clase del modelo debe tener un método save( Connection ) que recibe una
	    // conexion JDBC y hace que los datos del objeto se guarden en BBDD
	    //System.out.println( "INFO: insertadas [" + i + "] filas en BBDD." );
	}
	private static void jdbcDemo(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		conn.setAutoCommit(true);
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM APACHE_LOG_TBL");
		while (resultSet.next()) {
			System.out.print("Nombre: " + resultSet.getString("nombre"));
			System.out.print(" Email: " + resultSet.getString("email") + "\n");
		}
		resultSet.close();
		stmt.close();
		conn.close();
	}
	public static void insertIntoDataBase(Connection conn, String ip, String logTime, 
			String request, int result, int bytesNumber, String userAgent)
					throws Exception {
		String sql="INSERT INTO APACHE_LOG_TBL (ip, timestamp, request, result,"
				+ " bytes, ua) VALUES ("+ip+","+logTime+","+request+","+result
				+","+bytesNumber+","+userAgent+")";
		try (PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.setString(1, ip);
			stmt.setString(2, logTime);
			stmt.setString(3, request);
			stmt.setInt(4, result);
			stmt.setInt(5, bytesNumber);
			stmt.setString(6, userAgent);
			stmt.executeUpdate();
		}
	}
	public static boolean ipRangosBien(String ip) {
		String[] separados=ip.split("\\.");
		int ip0=Integer.parseInt( separados[0] );
		int ip1=Integer.parseInt( separados[1] );
		int ip2=Integer.parseInt( separados[2] );
		int ip3=Integer.parseInt( separados[3] );
		if ( ip0>255 || ip0<0 || ip1>255 || ip1<0 || ip2>255 || ip2<0 || ip3>255 || ip3<0) 
			return false;
		else {
			if(ip0==0 && ip1==0 && ip2==0 && ip3==0)
				return false;
			else {
				if(ip0==255 && ip1==255 && ip2==255 && ip3==255)
					return false;
				else
				return true;
			}
		}		
	}
}
