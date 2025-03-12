package com.gsd.daw.prog.ApacheAnalizer;

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
	    // Carga de objetos del modelo de BBDD a estructura plana
	    // Esto sin colecciones será un String[][] array de tamaño máximo 40000
	    // elementos
	    // Crea una clase aparte cuya responsabilidad sea recibir una conexion de BBDD 
	    // y devolver una estructura String[<tamano-de-los-datos>][6] con los datos en columnas
	    //System.out.println( "INFO: leidas [" + ponTuVariableAqui + "] lineas de BBDD." );
	    // Conversion de estructuras planas a objetos del modelo
	    // Reusa la clase que ya creaste para convertir la estructura "anónima"
	    // en un array de objetos del modelo
	    //System.out.println( "INFO: creados [" + ponTuVariableAqui + "] objetos del modelo." );
	    // Crea una clase separada para realizar cálculos y analisis sobre
	    // el array de objetos del modelo
	    // Puede ser una librería de funciones static (sin datos propios)
	    // que reciban un array de objetos del modelo y realicen cálculos sobre ellos
	    // Recuerda dividir responsabilidades entre calcular e imprimir.
	    // Los cálculos que se piden están especificados en el enunciado
	}
}
