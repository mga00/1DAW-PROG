package com.gsd.daw.prog.fil;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VisualizadorFil extends JPanel {
    private static final long serialVersionUID = 522183770612821283L;

    public VisualizadorFil( ImagenFil fil ) {
        super( new GridLayout( 1, 1 ) ); // 3 rows, 1 column
        JLabel label = new JLabel( fil2icon( fil ) );
        label.setToolTipText( fil.getComentario() );
        add( label );
    }
    
    private ImageIcon fil2icon( ImagenFil fil ) {
        BufferedImage img = new BufferedImage( fil.getAncho(), fil.getAlto(), BufferedImage.TYPE_INT_RGB );
        int i = 0;
        for ( int y = 0 ; y < fil.getAlto() ; y++ ) {
            for ( int x = 0 ; x < fil.getAncho() ; x++ ) {
                PixelRGB p = fil.getPixel( i++ );
                Color c = new Color( p.getRed(), p.getGreen(), p.getBlue() );
                img.setRGB( x, y, c.getRGB() );
            }
        }
        return new ImageIcon( img );
    }

}