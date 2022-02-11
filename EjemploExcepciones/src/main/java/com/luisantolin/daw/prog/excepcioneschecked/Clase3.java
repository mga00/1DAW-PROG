package com.luisantolin.daw.prog.excepcioneschecked;

import java.io.File;

public class Clase3 {

	public void otroMetodoMasDeEjemplo() {
		String valorQueVendríaDelUsuario = "fichero.txt";

		System.out.println(leeFichero(valorQueVendríaDelUsuario));
		System.err.println("ERROR: señor usuario, ese fichero no se puede leer.");
	}

	private String leeFichero( String nombreFichero ) {
		File f = new File(nombreFichero);
		// Scanner s = new Scanner(f); // descomentar esto
		String a = "";
		// leeriamos el fichero a un string
		return a;
	}

}
