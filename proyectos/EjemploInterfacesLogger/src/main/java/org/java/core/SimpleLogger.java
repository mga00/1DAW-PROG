package org.java.core;

/**
 * Implementación sencilla, simplemente imprime el mensaje por stdout
 */
public class SimpleLogger implements Logger {
    @Override
    public void log( String s ) {
        System.out.println( s );
    }

}
