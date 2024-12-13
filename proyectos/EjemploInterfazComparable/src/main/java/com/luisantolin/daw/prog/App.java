package com.luisantolin.daw.prog;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args )
    {
    	List<Persona> personas = new ArrayList<Persona>();
    	
    	personas.add( new Persona("Ernesto", 30));
    	personas.add( new Persona("Aitor", 20));
    	personas.add( new Persona("Berto", 40));
    	
    	System.out.println( personas.toString() );
    	personas.sort(null);
    	System.out.println( personas.toString() );
    }
}
