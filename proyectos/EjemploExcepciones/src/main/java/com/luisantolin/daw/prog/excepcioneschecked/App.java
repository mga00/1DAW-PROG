package com.luisantolin.daw.prog.excepcioneschecked;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Comienza el programa");
    	
    	Scanner s = new Scanner( System.in );
    	System.out.print( "Nombre de fichero?: " );
    	String nombreDeFichero = s.nextLine();
    	Clase1 c = new Clase1();
    	c.unMetodoEjemplo( nombreDeFichero );
    }
}
