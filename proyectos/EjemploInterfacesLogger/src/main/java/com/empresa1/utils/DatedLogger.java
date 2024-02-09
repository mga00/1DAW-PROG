package com.empresa1.utils;

import java.time.LocalTime;

import org.java.core.Logger;

/**
 * Imprime el mensaje por stdout añadiendole un timestamp delante.
 */
public class DatedLogger implements Logger {
    @Override
    public void log( String s ) {
        LocalTime localTime = LocalTime.now();
        System.out.println( localTime.toString() + ": " + s );
    }

}
