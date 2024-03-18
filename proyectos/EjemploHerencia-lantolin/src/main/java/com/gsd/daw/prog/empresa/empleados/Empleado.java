package com.gsd.daw.prog.empresa.empleados;

/**
 */
public abstract class Empleado {
    private String nombre;
    
    public Empleado( String nombre ) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
}
