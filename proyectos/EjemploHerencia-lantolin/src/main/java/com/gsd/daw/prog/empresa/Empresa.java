package com.gsd.daw.prog.empresa;

import java.util.ArrayList;
import java.util.List;

import com.gsd.daw.prog.empresa.empleados.Directivo;
import com.gsd.daw.prog.empresa.empleados.Empleado;

/**
 */
public class Empresa {
    private String nombre;
    private List<Empleado> empleados;
    private List<Directivo> directivos;
    private List<Departamento> departamentos;

    public void crearDepartamento( Departamento d ) {
        departamentos.add( d );
    }
    
    public void eliminarDepartamento( String nombre ) {
        //TODO: implementar
    }
    
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public List<Directivo> getDirectivos() {
        return directivos;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public Empresa( String nombre ) {
        this.nombre = nombre;
        this.empleados = new ArrayList<Empleado>();
        this.directivos = new ArrayList<Directivo>();
        this.departamentos = new ArrayList<Departamento>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void contratar( Empleado nuevoEmpleado ) {
        empleados.add( nuevoEmpleado );
    }

    public void contratarDirectivo( Directivo nuevoDirectivo ) {
        contratar( nuevoDirectivo );
        directivos.add( nuevoDirectivo );
    }
}
