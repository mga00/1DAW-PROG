package com.gsd.daw.prog;

import org.java.core.Logger;
import org.java.core.SimpleLogger;

import com.empresa1.utils.DatedLogger;
import com.empresa2.superlogger.SyserrDatedLogger;

/**
 * Demostración de un interfaz que sirve de estándar o API para poner de acuerdo
 * a todos los que lo implementan con los que lo usan. De este modo podemos
 * escribir una aplicación usando el interfaz Logger, y escogiendo la clase
 * concreta que lo instancia.
 * <p>
 * <code>Logger miLogger = new SimpleLogger()</code>
 * <p>
 * Ahora usamos tranquilamente la función definida en el interfaz:
 * <p>
 * <code>void log(String)</code><br>
 * <p>
 * Si más adelante queremos usar otra implementación BASTA CON CAMBIAR UNA
 * LINEA.
 * <p>
 * Este ejemplo/proyecto se entiende mucho mejor imaginando que hay varios
 * "actores" separados en el espacio y en el tiempo:
 * <ul>
 * <li>El equipo que define Logger y que hace la implementación
 * SimpleLogger</li>
 * <li>El equipo que hace la App</li>
 * <li>La empresa que decide mejorar la implementación y hace DatedLogger</li>
 * <li>Otra empresa que decide mejorar la implementación y hace
 * SyserrDatedLogger</li>
 * </ul>
 */
public class App {
    private static Logger miLogger = new SyserrDatedLogger();
//  private static Logger miLogger = new DatedLogger();
//    private static Logger miLogger = new SimpleLogger();

    public static Logger getLogger() {
        return miLogger;
    }

    public static void main( String[] args ) {
        miLogger.log( "Comienza el programa" );

        miLogger.log( "Comienza creacion de alumnos" );
        for ( int i = 0 ; i < 10 ; i++ ) {
            new Alumno( "alumno" + i );
        }
        miLogger.log( "Comienza creacion de profesores" );
        for ( int i = 0 ; i < 3 ; i++ ) {
            new Profesor( "profesor" + i );
        }
        miLogger.log( "Termina el programa" );
    }
}
