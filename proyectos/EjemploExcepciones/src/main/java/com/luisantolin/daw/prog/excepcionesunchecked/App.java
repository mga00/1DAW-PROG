package com.luisantolin.daw.prog.excepcionesunchecked;

import java.util.Random;

public class App {
	public static void main(String[] args) {
		Random generador = new Random();
		int valorQueVendríaDelUsuario = generador.nextInt(4);

		Clase1 c = new Clase1();
		c.unMetodoEjemplo(valorQueVendríaDelUsuario);
	}
}
