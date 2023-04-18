package com.luisantolin.daw.prog;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

/**
 * Ejemplo de uso del API estandar del JDK para logging
 * Se suele llamar Java Util Logging o JUL
 * Documentacion:
 * https://docs.oracle.com/en/java/javase/17/core/java-logging-overview.html
 * https://docs.oracle.com/en/java/javase/14/docs/api/java.logging/java/util/logging/package-summary.html
 * 
 * En este 1er ejemplo vamos a ver los conceptos y como manejar los Loggers desde el propio 
 * código fuente. Esta no es la mejor manera ni la más profesional, en el ejemplo 2 veremos
 * como se configura y maneja usando un fichero de propiedades
 */
public class App {
    private static Logger LOGGER;

    public static void main( String[] args ) {
        LOGGER = Logger.getLogger( "LOGGER TEST 1" );
        
        // Logeando.
        // Ejemplos de mensajes de múltiples niveles, ordenados por nivel
        // como el Logger y el Handler por defecto tienen configurado nivel INFO
        // alguno de estos mensajes no se veran
        LOGGER.log( Level.SEVERE, "Ejemplo de mensaje de nivel severe. Curiosamente el nivel ERROR no existe 🤷🏼" );
        LOGGER.log( Level.WARNING, "Ejemplo de mensaje de nivel WARNING" );
        LOGGER.log( Level.INFO, "Ejemplo de mensaje de nivel INFO" );
        LOGGER.log( Level.CONFIG, "Ejemplo de mensaje de nivel CONFIG" );
        LOGGER.log( Level.FINE, "Ejemplo de mensaje de nivel FINE. Curiosamente el nivel DEBUG no existe 🤷🏿" );
        LOGGER.log( Level.FINER, "Ejemplo de mensaje de nivel FINER" );
        LOGGER.log( Level.FINEST, "Ejemplo de mensaje de nivel FINEST" );

        // formatos cortos, para usos simples
        LOGGER.info( "Mensaje de nivel info, formato corto" );
        LOGGER.severe( "Mensaje de nivel severe" );

        // Ejemplo de guarded-logging
        String demo = "41";
        LOGGER.log( Level.INFO, "Ejemplo de NON guarded logging. La variable demo vale " + demo + " y deberia valer 42." );
        LOGGER.log( Level.INFO, "Ejemplo de     guarded logging. La variable demo vale {0} y deberia valer 42.", demo );
        // parecen iguales pero la diferencia es que la suma string+string+string ocurre siempre, aunque no se logee, mientras que en la
        // 2a version solo ocurre si se va a logear

        // Ejemplo: Imprimir informacion del propio logger
        LOGGER.log( Level.INFO, "El nombre de este logger es: {0}", LOGGER.getName() );

        // SEGUNDA PARTE
        
        // Vamos a controlar el logger a traves de su API
        // Cambiar el nivel de logging por defecto
        LOGGER.setLevel( Level.FINE );
        // OJO, si queremos que un mensaje FINE se imprima, tengo que cambiar el Level en dos sitios
        // el Logger y el Handler porque se pasa por esos **dos filtros**
        // OJO, un Logger puede no tener Handlers y si no los tiene va a mandar el mensaje a su Logger
        // padre, asi que hago una doble chapuza, 1a asumo que el Logger tiene un padre y lo obtengo,
        // 2a asumo que el 1er Handler es el que quiero cambiar, como se que solo hay uno, pues me vale
        LOGGER.getParent().getHandlers()[0].setLevel( Level.FINE );

        LOGGER.log( Level.INFO, "El nivel de log de este Logger es: {0}", LOGGER.getLevel() );
        LOGGER.log( Level.INFO, "El nivel del primer Handler es: {0}", LOGGER.getParent().getHandlers()[0].getLevel() );
        LOGGER.fine( "Ahora este mensaje SI que se va a imprimir." );

        
        // Añadir un handler para que haga logging a un fichero, que use el formateador simple
        Handler FILE_H;

        try {
            FILE_H = new FileHandler( "logs/trazas.log", true );
        } catch ( IOException e ) {
            e.printStackTrace();
            return;
        }

        FILE_H.setFormatter( new XMLFormatter() );
        LOGGER.addHandler( FILE_H );
        LOGGER.severe( "Ejemplo de mensaje que se va a imprimir a consola y fichero." );

        // Cambiar el formato que usa el SimpleFormatter
        // no es facil de modo programatico
        // no me lio mas aqui porque esta no es la manera buena de usar un Logger
        // la manera buena es usar un fichero de propiedades
        
        // Al final de este ejemplo podemos enseñar como si ejecuto desde Eclipse sale una cosa
        // y si ejecuto desde maven sale otra.
        //
        // ¿porque?
        // 
        // Porque el JRE que se usa en Eclipse es uno concreto y tiene un logging.properties 
        // mientras que cuando ejecuto con Maven uso el JRE del SO que tiene un logging.properties
        // diferente.
        // Solucion y buena práctica profesional: el logging.properties tiene que ser parte del proyecto
        // para que lo tengamos controlado
    }
}
