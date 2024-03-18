package com.gsd.daw.prog.empresa.empleados;

/**
 */
public abstract class EnConvenio extends Empleado {
    private Convenio convenio;
    
    public EnConvenio( String nombre, Convenio convenio ) {
        super( nombre );
        this.convenio = convenio;
    }
    
    public Convenio getConvenio() {
        return convenio;
    }
}
