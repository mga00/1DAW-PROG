package com.gsd.daw.prog;

public class Alumno {
    private String nombre;
    
    public Alumno( String nombre ) {
        App.getLogger().log( "Creando Alumno [" + nombre + "]" );
        
        this.nombre = nombre;
    }

}
