package com.luisantolin.daw.prog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculadoraTest 
{
    /**
     * Comprueba que la función devuelva la suma de los dos
     * números pasados como argumentos
     */
    @Test
    public void laSumaEsCorrecta()
    {
        Calculadora c = new Calculadora();
        int resultado = c.suma( 2, 3 );
        
        assertEquals( 5, resultado );
    }
}


