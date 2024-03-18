package com.gsd.daw.prog.empresa.empleados;

import com.gsd.daw.prog.empresa.Departamento;

/**
 */
public class Administrativo extends EnConvenio {
    private Departamento departamento;

    public Administrativo( String nombre, Departamento departamento ) {
        super( nombre,
               new Convenio( "Oficinas y Despachos" ) );
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
