package com.luisantolin.daw.prog;

public class Persona implements Comparable<Persona> {
	private String nombre;
	private Integer edad;

	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public int compareTo( Persona o ) {
		return compareByName(o);
	}

	private int compareByName( Persona o ) {
		return this.nombre.compareTo(o.nombre);
	}

	private int compareByAge( Persona o ) {
		return this.edad.compareTo(o.edad);
	}

	// quitar este método para que vean el efecto de no tenerlo.
	public String toString() {
		return "nombre->" + nombre + " edad->" + edad;
	}

}
