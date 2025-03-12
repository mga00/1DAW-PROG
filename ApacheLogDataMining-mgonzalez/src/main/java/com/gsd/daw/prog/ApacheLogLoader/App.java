package com.gsd.daw.prog.ApacheLogLoader;

public class App {
	
	public static void main(String[] args) {
	    // Comprobación de argumentos
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
	    // Creacion de la conexión
	    System.out.println( "INFO: conectado a BBDD." );
	    // Lectura de datos a estructuras planas
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
}
