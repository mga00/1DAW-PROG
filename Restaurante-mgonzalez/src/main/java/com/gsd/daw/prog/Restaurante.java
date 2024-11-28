package com.gsd.daw.prog;

import java.util.Arrays;

public class Restaurante {
	private String nombre;
	private int [] mesas;
	
	public Restaurante(String nombre, int tamano) {//constructor por defecto es sin aceptar ninguna variable y vacio en el interior
		if (tamano<1) {
			throw new IllegalArgumentException("El tamaño del restaurante no puede ser 0 ni negativo.");//tirar la excepcion
		}
		if (nombre==null || nombre.isEmpty()) {
			throw new IllegalArgumentException("El nombre del restaurante no puede ser null ni estar vacio.");
		}
		mesas= new int[tamano];
		this.nombre=nombre;
	}
	
	public String toString() {
		return nombre+": "+Arrays.toString(mesas);
	}
	
	public void sentarMesa(int numGente) {//ya no es estatico
		if (numGente<=0) {
			throw new IllegalArgumentException("El numero de personas no puede ser 0 ni negativo");
		}
		for (int i = 0; i < mesas.length; i++) {
			if(mesas[i]==0) {
				mesas[i]=numGente;
				return;
			}
		}
	}

	 public void levantarMesa(int posicion) {
		 if (posicion<0 || posicion>=mesas.length) {
			 throw new IllegalArgumentException("El numero de mesa no es correcto");
		}
		 mesas[posicion]=0;
	 }

	 public int contarOcupadas() {
	  int total = 0;
	  for (int i = 0; i < mesas.length; i++) {
		
	}
	  return total;
	 }

	 public int contarClientes() {
	  int total = 0;
	  for (int i = 0; i < mesas.length; i++) {
		total+=mesas[i];
	}
	  return total;
	 }

	 public void reagruparMesas() {
		 for (int i = mesas.length-1; i >1 ; i--) {
			int gente=mesas[i];
			if(gente>0) {
			levantarMesa(i);
			sentarMesa(gente);
			}
		}
	 }
	}
