package com.gsd.daw.prog;

public class App {
	public static void main(String[] args) {
		if (args.length!=2) {//comprobar si el numero de argumentos es igual a dos
			System.err.println("Error: has introducido un numero de argumentos no permitido-------+++");
			return;
		}
		String cidr=args[1];
		String ip=args[0];
		if (Funciones.cidrIntValido(cidr)==false) {//comprueba que la máscara sea un entero válido
			System.err.println("Error: la máscara de red no es un entero válido");
			return;
		}
		int cidr1=Integer.parseInt(cidr);
		if (Funciones.rangosCidrBien(cidr1)==false) {//comprueba que el cidr este entre el numero 0 y el 24 
			System.err.println("Error: la máscara de red tiene un valor que no es válido");
			return;
		}
		if (Funciones.ipIntValido(ip)==false) {//comprobar que la ip son enteros
			System.err.println("Error: los datos introducidos no representan una ip");
			return;
		}
		if(Funciones.ipNoMenosCero(ip)==false) {//comprueba que la ip no tenga campos que sean -0
			System.err.println("Error: los campos de la ip no tiene los enteros correctos");
			return;
		}
		if (Funciones.ipCamposCorrectos(ip)==false) {//comprobar que la ip tiene cuatro campos
			System.err.println("Error: la ip introducida no tiene los campos correctos");
			return;
		}
		if (Funciones.ipRangosBien(ip)==false) {//comprueba que los numeros de la ip esten entre el 255 y el 0
			System.err.println("Error: Los campos de la ip no son correctos");
			return;
		}
		System.out.println(args[0]+"/"+args[1]);
		Funciones.clase(ip, cidr1);
	}
		
	
}
