package com.gsd.daw.prog;

import com.gsd.daw.prog.api.Alumno;
import com.gsd.daw.prog.api.UnApi;

/**
 * Ejemplo de uso super sencillo, pero muy eficiente, de lombok en Maven
 * funciona sin problemas, en Eclipse hay que añadir el soporte de lombok como
 * indica esta página https://projectlombok.org/setup/eclipse para que Eclipse
 * no de errores por el código que no existe (el que genera lombok)
 */
public class App {
    /**
     * Punto de entrada de la aplicación
     * 
     * @param args No se espera ningún parámetro.
     */
    public static void main( String[] args ) {
        Alumno a = new Alumno();
        a.setEdad( 20 );
        a.setNombre( "Ernesto Mate" );
        System.out.println( a.toString() );
    }
}
