package com.luisantolin.daw.prog.automoviles;

public class Fabrica {
	private int numCochesFabricados;
	static private int numTotalCochesFabricados = 0;
	static private int numFabricas = 0;
	private String nombre;
	
	public Fabrica( String nombre ) {
		this.nombre = nombre;
		numCochesFabricados = 0;
		numFabricas++;
	}
	
	public int getNumCochesFabricados() {
		return numCochesFabricados;
	}
	
	public static int getNumTotalCochesFabricados() {
		return numTotalCochesFabricados;
	}
	
	public Coche fabricarCoche( String matricula ) {
		numCochesFabricados++;
		numTotalCochesFabricados++;
		return new Coche( matricula );
	}
	
	public static int getNumFabricas() {
		return numFabricas;
	}
}
