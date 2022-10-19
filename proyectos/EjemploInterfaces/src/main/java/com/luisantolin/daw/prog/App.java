package com.luisantolin.daw.prog;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 * Proyecto para ser usado como ejemplo o base para un proyecto Java.
 * Características:
 * <ol>
 * <li>Maven, configurado para usar JUnit 5 y Java 8</li>
 * <li>El proyecto se llama Nombre-id1 (tienes que poner tu id1</li>
 * <li>La clase que contiene el metodo main() que lanza la funcionalidad es App, eso esta configurado en pom.xml</li>
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
