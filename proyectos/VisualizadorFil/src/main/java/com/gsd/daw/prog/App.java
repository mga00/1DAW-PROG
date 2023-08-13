package com.gsd.daw.prog;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
    public static void main( String[] args ) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        } );
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame( "Visualizador FIL" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( new VisualizadorFil() );
        frame.pack();
        frame.setVisible( true );
    }

}
