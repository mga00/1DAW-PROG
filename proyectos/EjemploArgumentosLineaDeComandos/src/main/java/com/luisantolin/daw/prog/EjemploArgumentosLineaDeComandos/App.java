package com.luisantolin.daw.prog.EjemploArgumentosLineaDeComandos;

public class App {
    public static void main( String[] a ) {

// Comprobación del número de argumentos (si hiciera falta)
//		final int MIN_ARGS=1;
//		final int MAX_ARGS=4;
//    	if ( a.length < MIN_ARGS || a.length > MAX_ARGS ) {
//    		System.err.println("Argumentos insuficientes o demasiados");
//    		return;
//    	}

        // Imprimir el numero de argumentos que me pasan
        System.out.println( a.length );

        if ( a.length >= 1 ) { // evitando el AAOB, si ya has hecho un control previo esto no haría falta
            System.out.println( "Hello " + a[0] );
        }

        // imprimiendo todos los argumentos, uno en cada línea
        for ( int i = 0 ; i < a.length ; i++ ) {
            System.out.println( "===" + a[i] + "===" );
        }
    }

}
