package com.luisantolin.daw.prog.PaqueteIncorrecto;

public class nombreDeClaseIncorrecto {
    public static final int CONSTANTE            = 0;
    public static final int constanteMalNombrada = 0; // esta es ignorada, por tanto el error no es detectado

    public int noDebeHaberMiembrosPublicos;
    int        noDebeHaberMiembrosPackage;

    public void NombreDeMetodoIncorrecto() {

    }

    private void metodo2( int ParametroMal, int otro_parametro_mal ) {
        int VariableMal;
        String[] arrayBien = new String[20]; // numero magico
        String arrayMal[];

        for ( int i = 0 ; i < 10 ; i++ ) { // numero magico
            System.out.println( i );
        }

    }

}
