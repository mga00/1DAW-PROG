package com.empresa2.superlogger;

import java.time.LocalTime;

import org.java.core.Logger;

/**
 * Imprime el mensaje por stderr poniendo delante un timestamp y añade el PID del proceso.
 */
public class SyserrDatedLogger implements Logger {
    @Override
    public void log( String s ) {
        LocalTime localTime = LocalTime.now();
        System.err.println( localTime.toString() + ": [" + ProcessHandle.current().pid() + "] : " + s );
    }

}
