package com.gsd.daw.prog;

public class MiArrayPooBueno {
    static final private int MAX_SIZE = 4;
    private int[] array = new int[MAX_SIZE];

    public void addToArray( int posicion, int elemento ) {
        if ( posicion >= MAX_SIZE || posicion < 0 ) {
            return;
        }
        array[posicion] = elemento;
        return;
    }
    
}
