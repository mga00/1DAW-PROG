package com.gsd.daw.prog.fil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImagenFil {
    private String comentario;
    private int      ancho;
    private int      alto;
    private PixelRGB pixels[];

    public ImagenFil( String nombreFichero ) {
        Scanner inputFile = null;
        try {
            File f = new File( nombreFichero );
            inputFile = new Scanner( f );
        } catch ( FileNotFoundException e ) {
            System.err.println( "ERROR: no se puede abrir el fichero" );
        }

        comentario = inputFile.nextLine();
        ancho = Integer.parseInt( inputFile.nextLine() );
        alto = Integer.parseInt( inputFile.nextLine() );

        int numPixels = ancho * alto;
        pixels = new PixelRGB[numPixels];

        for ( int i = 0 ; i < numPixels ; i++ ) {
            String line = inputFile.nextLine();
            String[] rgb = line.split( "," );
            pixels[i] = new PixelRGB( Integer.parseInt( rgb[0] ), Integer.parseInt( rgb[1] ), Integer.parseInt( rgb[2] ) );
        }
        inputFile.close();
    }
    
    public String getComentario() {
        return comentario;
    }
    
    public int getAncho() {
        return ancho;
    }
    
    public int getAlto() {
        return alto;
    }
    
    public PixelRGB getPixel( int i ) {
        return pixels[i];
    }
   

}
