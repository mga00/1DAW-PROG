package com.gsd.daw.prog.empresa.empleados;

import com.gsd.daw.prog.empresa.Departamento;

/**
 */
public class Tecnico extends EnConvenio {
    private Departamento departamento;

    public Tecnico( String nombre, Departamento departamento ) {
        super( nombre,
               new Convenio( "Metal" ) );
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
