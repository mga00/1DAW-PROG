package com.gsd.daw.prog;

public class Profesor {
    private String nombre;
    
    public Profesor( String nombre ) {
        App.getLogger().log( "Creando Profesor [" + nombre + "]" );
        
        this.nombre = nombre;
    }

}
