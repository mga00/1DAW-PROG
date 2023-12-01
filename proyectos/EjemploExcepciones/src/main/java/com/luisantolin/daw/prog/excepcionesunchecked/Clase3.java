package com.luisantolin.daw.prog.excepcionesunchecked;

public class Clase3 {
	String[] cosas = new String[] { "una cosa", "otra cosa" };

	public void otroMetodoMasDeEjemplo(int num) {
		System.out.println(getCosa(num));
	}

	public int getNumCosas() {
		return cosas.length;
	}

	private String getCosa(int indice) {
		return cosas[indice];
	}
}
