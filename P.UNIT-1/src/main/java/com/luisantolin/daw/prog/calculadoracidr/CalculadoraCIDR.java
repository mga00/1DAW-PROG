package com.luisantolin.daw.prog.calculadoracidr;

public class CalculadoraCIDR {

	public static void main(String[] args) {
		String ipString = "";
		String mascaraString = "";

		if (args.length != 2) {
			System.out.print("USO: CalculadoraCIDR <ip> <bits de máscara>\n");
			return;
		}

		ipString = args[0];
		mascaraString = args[1];

		System.out.println("Comenzamos cálculos para la IP [" + ipString + "] y máscara [" + mascaraString + "]");

		Ip ip = new Ip(ipString, mascaraString);
		System.out.println("La direccion de red es [" + ip.calculaDireccionDeRed()  + "]" );
	}
}
