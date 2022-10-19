package com.luisantolin.daw.prog;

public class App 
{
    public static void main( String[] args )
    {
    	Dios d1 = Dios.aparicionDivina(); 
        System.out.println( "Ha aparecido " + d1.getNombre() + " dirección de memoria " + d1 );
        
    	Dios d2 = Dios.aparicionDivina(); 
        System.out.println( "Ha aparecido " + d2.getNombre() + " dirección de memoria " + d2 );
    }
}
