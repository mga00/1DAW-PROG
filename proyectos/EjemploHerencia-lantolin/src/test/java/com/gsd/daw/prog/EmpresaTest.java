package com.gsd.daw.prog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.gsd.daw.prog.empresa.Empresa;

@TestMethodOrder( MethodOrderer.DisplayName.class )
public class EmpresaTest {
    Empresa gruLabs = new Empresa("Gru Labs");

    @Test
    @DisplayName( "Constructor 1" )
    public void constructor1() {
        assertEquals( "Gru Labs", gruLabs.getNombre() );
    }
}
