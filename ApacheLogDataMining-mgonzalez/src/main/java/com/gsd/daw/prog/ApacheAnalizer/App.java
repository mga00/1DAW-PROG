package com.gsd.daw.prog.ApacheAnalizer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gsd.daw.prog.ApacheLogLoader.CompArgs;
import com.gsd.daw.prog.ApacheLogLoader.LineaLog;

public class App {
	
	public static void main(String[] args) {
		// Comprobación de numero de argumentos
		if(args.length>4) {
			System.err.println("Error: Has puesto demasiados argumentos.");
			return;
		}
		if(args.length<4) {
			int argsNum=4-args.length;
			if (argsNum==1) {
				System.err.println("Error: Te falta "+argsNum+" dato");
				return;
			}
			System.err.println("Error: Te faltan "+argsNum+" datos");
			return;
		}
		
	    // Creacion de la conexión y comprobacion de ip
		String ip=args[0];
		if (!CompArgs.compIp(ip)) {
			System.err.println("Error: La ip no es correcta");
			return;
		}
		String nombre=args[1];
		
		String url="jdbc:oracle:thin:@//"+ip+"/"+nombre;
	    String user=args[2];
	    
	    String contra=args[3];
	    String query= "Select * from apache_log_tbl";
	    
	    // Carga de objetos del modelo de BBDD a estructura plana
	    List<String[]> logsBbdd = new ArrayList<>();
	    
	    //probar conexion con un try
	    try (Connection conn = DriverManager.getConnection(url, user, contra)) {
	    	Statement stmt = conn.createStatement();
	    	ResultSet rs = stmt.executeQuery(query);
	    	int contador= rs.getMetaData().getColumnCount();
	    	while (rs.next()) {
	    		String[] fila = new String[contador];
	    		for (int i = 1; i <= contador; i++) {
					fila[i-1] = rs.getString(i);
				}
	    		logsBbdd.add(fila);
	    	}
		} catch (SQLException e) {
			System.err.println("ERROR: excepción SQL: " + e.getMessage());
			return;
		}
		System.out.println( "INFO: conectado a BBDD." );
	    System.out.println( "INFO: leidas [" + logsBbdd.size() + "] lineas de BBDD." );
	    
	    // Conversion de estructuras planas a objetos del modelo
	    // Reusa la clase que ya creaste para convertir la estructura "anónima"
	    // en un array de objetos del modelo
	    List<LineaLogA> logsLista1 = new ArrayList<>();
	    for(String[] linea: logsBbdd) {
	    	LineaLogA l = new LineaLogA(linea[0], linea[1], linea[2], linea[3], linea[4], linea[5]);
	    	logsLista1.add(l);
	    }
	    System.out.println( "INFO: creados [" + logsLista1.size() + "] objetos del modelo." );
	    // Crea una clase separada para realizar cálculos y analisis sobre
	    // el array de objetos del modelo
	    // Puede ser una librería de funciones static (sin datos propios)
	    // que reciban un array de objetos del modelo y realicen cálculos sobre ellos
	    // Recuerda dividir responsabilidades entre calcular e imprimir.
	    // Los cálculos que se piden están especificados en el enunciado
	    Calculos c= new Calculos();
	    Map<String, Integer> mapaIpsMas10=c.cuantasIps(logsLista1);
	    c.mostrarIps(mapaIpsMas10);
	    Map<String, Integer> contadorStCode=c.contadorStatusCode(logsLista1);
	    c.MostrarListaStCode(contadorStCode);
	}
}
