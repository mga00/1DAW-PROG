package com.luisantolin.daw.debugger;

/**
 * Implementación super-cutre, solo imprime el nombre de la clase
 * @author lantolin
 *
 */
public class UnDebuggerBasico implements Debugger {
    public void debug( Object o ) {
        try {
            System.out.println( "Class: " + o.getClass() );
        } catch ( Exception e ) {
            System.err.println( e.getMessage() );
        }
    }
}
