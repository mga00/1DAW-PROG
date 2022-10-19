package com.luisantolin.daw.prog;

public class Dios {
	private String nombre;
	private static Dios unicoDios;
	
	private Dios() {
		nombre = "Geovah";
	}

	public String getNombre() {
		return nombre;
	}
	
	static public Dios aparicionDivina() {
		if ( unicoDios == null ) {
			unicoDios = new Dios();
		}
		return unicoDios;
	}
}
