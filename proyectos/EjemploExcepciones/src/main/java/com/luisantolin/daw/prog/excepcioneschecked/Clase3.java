package com.luisantolin.daw.prog.excepcioneschecked;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Clase3 {

    public void otroMetodoMasDeEjemplo( String fichero ) {
        System.out.println( leeFichero( fichero ) );
    }
    
    // PARA empezar el ejercicio descomenta las líneas de esta funcion
    private String leeFichero( String nombreFichero ) {
        File f = new File( nombreFichero );
//        Scanner s = null;
//        s = new Scanner( f ); 
        String a = "DUMMY";
//        a = s.nextLine(); 
//        s.close();        
        return a;
    }

    // esta sería la primera solución, voy obligado por que las checked 
    // hay que manejarlas, pero no es la mejor solución ya que no le da
    // al que crea el problema la oportunidad de darse cuenta y solucionarlo
    // ¿sabrías mejorarla?
    private String leeFicheroPrimeraSolucion( String nombreFichero ) {
        File f = new File( nombreFichero );
        Scanner s = null;
        try {
            s = new Scanner( f );
        } catch ( FileNotFoundException e ) {
            System.err.println( "ERROR: señor usuario, ese fichero no se puede leer. ERROR: " + e.getMessage() );
            return null;
        }
        String a = "";
        a = s.nextLine(); // leemos la 1a linea del fichero a un string
        s.close();
        return a;
    }

}
