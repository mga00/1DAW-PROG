package com.luisantolin.daw.prog;

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
    private int NombreDeVariableIncorrecto;
    private int nombre_de_variable_incorrecto;
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public void unMetodo() {
        System.exit( 1 ); // System.exit no se puede usar, hay que salir de manera ordenada.
       
        // System.exit( 1 )  esto no debe dar problema
    }
    
    public void otroMetodo() {
        System.exit
        ( 1 ); // System.exit no se puede usar, hay que salir de manera ordenada.
       
        // System.exit( 1 )  esto no debe dar problema
    }

    public void otroMetodoMas() {
        System.
        exit
        ( 
        1
        ); // System.exit no se puede usar, hay que salir de manera ordenada.
       
        // System.exit( 1 )  esto no debe dar problema
    }
}
