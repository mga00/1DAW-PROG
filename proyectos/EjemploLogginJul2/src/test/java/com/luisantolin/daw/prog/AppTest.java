package com.luisantolin.daw.prog;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class AppTest {
    private final static Logger LOGGER = Logger.getLogger( "LOGGER TEST 2" );

    static {
        InputStream ficheroDeConfiguracion = App.class.getClassLoader().getResourceAsStream( "config/logging-test.properties" );
        try {
            LogManager.getLogManager().readConfiguration( ficheroDeConfiguracion );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldAnswerWithTrue() {
        LOGGER.log( Level.SEVERE, "Ejemplo de mensaje de nivel severe. Curiosamente el nivel ERROR no existe 🤷🏼" );
        LOGGER.log( Level.WARNING, "Ejemplo de mensaje de nivel WARNING" );
        LOGGER.log( Level.INFO, "Ejemplo de mensaje de nivel INFO" );
        LOGGER.log( Level.CONFIG, "Ejemplo de mensaje de nivel CONFIG" );
        LOGGER.log( Level.FINE, "Ejemplo de mensaje de nivel FINE. Curiosamente el nivel DEBUG no existe 🤷🏿" );
        LOGGER.log( Level.FINER, "Ejemplo de mensaje de nivel FINER" );
        LOGGER.log( Level.FINEST, "Ejemplo de mensaje de nivel FINEST" );
        assertTrue( true );
    }
}
