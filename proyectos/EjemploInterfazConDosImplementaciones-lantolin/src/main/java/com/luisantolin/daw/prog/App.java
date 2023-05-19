package com.luisantolin.daw.prog;

import com.luisantolin.daw.debugger.Debugger;

/**
 * Ejemplo de varias cosas: 
 * 1. un interfaz (Debugger) que tiene dos implementaciones 
 * 2. como construir una clase solo sabiendo su
 * Fully-Qualified-Name 
 * 3. como hacer "inyeccion" de codigo es decir que mi App use una clase u otra
 * 
 * @author lantolin
 */
public class App {
    public static void main( String[] args ) throws Exception {

        // esta variable debe contener el FQName de la clase que usaremos como
        // debugger, si viene vacio pongo un valor por defecto
        String debuggerClass = null;
        if ( args.length < 1 || args[0] == null ) {
            debuggerClass = "com.luisantolin.daw.debugger.UnDebuggerBasico";
        } else {
            debuggerClass = args[0];
        }
        
        // Uso reflection para construir un Objeto Java a partir de su nombre 
        // de clase
        Debugger d = (Debugger) Class.forName( debuggerClass ).getConstructor().newInstance();

        // Creo unos objetos de prueba
        Alumno uno = null;
        Alumno dos = new Alumno();
        Alumno tres = new Alumno( "Ernesto Mate", 42 );

        // Los "debugeo"
        d.debug( uno );
        d.debug( dos );
        d.debug( tres );
    }
}
