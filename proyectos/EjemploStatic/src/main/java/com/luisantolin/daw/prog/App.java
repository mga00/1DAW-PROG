package com.luisantolin.daw.prog;

import com.luisantolin.daw.prog.automoviles.Coche;
import com.luisantolin.daw.prog.automoviles.Fabrica;

public class App 
{
    public static void main( String[] args )
    {
    	// Coche c = new Coche("1111");   // esto no se puede hacer, es intencionado, no se pueden "fabricar" coches sin usar la fabrica
    	
        System.out.println( Fabrica.getNumFabricas() ); // 0
        Fabrica peugeot = new Fabrica( "Peugeot");
        System.out.println( Fabrica.getNumFabricas() ); // 1
        Fabrica citroen = new Fabrica( "Citroen");
        System.out.println( Fabrica.getNumFabricas() ); // 2
        Fabrica seat = new Fabrica( "Seat");
        System.out.println( Fabrica.getNumFabricas() ); // 3
        Coche coche1 = peugeot.fabricarCoche("4545");
        Coche coche2 = peugeot.fabricarCoche("4546");
        Coche coche3 = peugeot.fabricarCoche("4547");
        System.out.println( peugeot.getNumCochesFabricados() ); // 3 
        System.out.println( Fabrica.getNumTotalCochesFabricados() ); // 3
        Coche coche5 = seat.fabricarCoche("3545");
        Coche coche6 = seat.fabricarCoche("3546");
        Coche coche7 = seat.fabricarCoche("3547");
        Coche coche8 = seat.fabricarCoche("3548");
        System.out.println( seat.getNumCochesFabricados() ); // 4
        System.out.println( Fabrica.getNumTotalCochesFabricados() ); // 7
    }
}
