package com.gsd.daw.prog;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VisualizadorFil extends JPanel {
    private static final long serialVersionUID = 522183770612821283L;

    public VisualizadorFil() {
        super( new GridLayout( 1, 1 ) ); // 3 rows, 1 column
        JLabel label = new JLabel( calcularImagen() );
        label.setToolTipText( "Futuro comentario de la imagen (metadata)" );
        add( label );
    }
    
    private ImageIcon calcularImagen() {
        BufferedImage img = new BufferedImage( 800, 600, BufferedImage.TYPE_INT_RGB );
        for ( int y = 0 ; y < 600 ; y++ ) {
            for ( int x = 0 ; x < 800 ; x++ ) {
                Color c = new Color( ThreadLocalRandom.current().nextInt(0, 256), ThreadLocalRandom.current().nextInt(0, 256), ThreadLocalRandom.current().nextInt(0, 256));
                img.setRGB( x, y, c.getRGB() );
            }
        }
        return new ImageIcon( img );
    }

}