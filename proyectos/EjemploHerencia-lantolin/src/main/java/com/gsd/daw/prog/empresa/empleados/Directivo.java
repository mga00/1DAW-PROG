package com.gsd.daw.prog.empresa.empleados;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Directivo extends Empleado {
    private String titulo;
    private List<Empleado> empleadosQueGestiona;
    
    public Directivo( String nombre, String titulo ) {
        super( nombre );
        this.titulo = titulo;
        empleadosQueGestiona = new ArrayList<Empleado>();
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Empleado> getEmpleadosQueGestiona() {
        return empleadosQueGestiona;
    }   
    
    public void addGestionado( Empleado e ) {
        empleadosQueGestiona.add( e );
    }
    
}
