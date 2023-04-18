package com.luisantolin.daw.prog;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Continuación del ejemplo 1 
 * 
 * Ahora vamos a hacerlo bien, usando un fichero de configuración que será parte del proyecto Eclipse y Maven y que quedará
 * empaquetado en el JAR para que se distribuja junto con el software
 * 
 * Esto en Java se llama Location-Independent Access to Resources y es una parte fundamental de crear entregables de 
 * forma profesional de modo que funcionen de una forma consistente y predecible
 * https://docs.oracle.com/javase/8/docs/technotes/guides/lang/resources.html 
 * 
 * Integracion con Maven: OJO, el logging.properties no esta puesto en cualquier sitio, está en src/main/resources para que Maven (y eclipse con los
 * plugins de Maven) lo puedan encontrar y lo copien al sitio correcto en el CLASSPATH
 * 
 * Integracion con Git: otra buena practica, para evitar que git añada los logs y nos esté continuamente diciendo que han cambiado hay que
 * ponerlos todos bajo un mismo directorio y añadir ese directorio al .gitignore
 * 
 * Integración con Junit: hemos creado dos ficheros de log uno para PROD y otro para TEST. Maven nos facilita esto y es una configuracion
 * muy realista ya que las necesidades de logging varian mucho con cada entorno
 */
public class App {
    private static Logger LOGGER;

    public static void main( String[] args ) {

        InputStream ficheroDeConfiguracion = App.class.getClassLoader().getResourceAsStream( "config/logging-prod.properties" );
        try {
            LogManager.getLogManager().readConfiguration( ficheroDeConfiguracion );
        } catch ( IOException e ) {
            e.printStackTrace();
            return;
        }

        LOGGER = Logger.getLogger( "LOGGER TEST 2" );

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
    }
}
