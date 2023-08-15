package com.gsd.daw.prog;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.gsd.daw.prog.fil.ImagenFil;
import com.gsd.daw.prog.fil.VisualizadorFil;

public class App {
    public static void main( String[] args ) {
        
        if (args.length < 1) {
            System.err.println("USO: java -jar <nombre-jar> <nombre-de-fichero FIL>");
            return;
        }
       
        String nombreFichero = args[0];
        ImagenFil img = new ImagenFil( nombreFichero );

        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                createAndShowGUI( img );
            }
        } );
    }

    private static void createAndShowGUI( ImagenFil img ) {
        JFrame frame = new JFrame( "Visualizador FIL" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( new VisualizadorFil( img ) );
        frame.pack();
        frame.setVisible( true );
    }

}
