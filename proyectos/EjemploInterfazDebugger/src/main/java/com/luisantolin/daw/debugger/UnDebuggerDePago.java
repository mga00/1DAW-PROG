package com.luisantolin.daw.debugger;

import java.lang.reflect.Field;

/**
 * Implementación buena-buena, imprime el nombre de la clase, y una lista de los campos con su nombre y valor
 * 
 * @author lantolin
 *
 */
public class UnDebuggerDePago implements Debugger {
    public void debug( Object o ) {
        if ( o == null ) {
            System.out.print( "===================================\nnull\n===================================\n" );
            return;
        }

        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty( "line.separator" );

        result.append( "===================================" );
        result.append( newLine );
        result.append( "CLASE: " );
        result.append( o.getClass().getName() );
        result.append( newLine );

        Field[] fields = o.getClass().getDeclaredFields();

        for ( Field field : fields ) {
            result.append( "  " );
            try {
                result.append( field.getName() );
                result.append( ": " );
                // requires access to private field:
                field.setAccessible( true );
                result.append( field.get( o ) );
            } catch ( IllegalAccessException ex ) {
                System.out.println( ex );
            }
            result.append( newLine );
        }
        result.append( "===================================" );
        result.append( newLine );

        System.out.print( result.toString() );
    }
}
