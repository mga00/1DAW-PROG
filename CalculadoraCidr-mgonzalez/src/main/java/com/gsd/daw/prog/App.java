package com.gsd.daw.prog;

public class App {
	public static void main(String[] args) {
		if (!Funciones.errorNumArgum(args.length)) {
			return;
		}
		Funciones f=new Funciones();
		String cidr=args[1];
		String ip=args[0];
		int cidr1=Integer.parseInt(cidr);
		if (Funciones.rangosCidrBien(cidr1)==false) {//comprueba que el cidr este entre el numero 0 y el 24 
			return;
		}
		if (Funciones.ipIntValido(ip)==false) {//comprobar que la ip son enteros
			return;
		}
		if(Funciones.ipNoMenosCero(ip)==false) {//comprueba que la ip no tenga campos que sean -0
			return;
		}
		if (Funciones.ipCamposCorrectos(ip)==false) {//comprobar que la ip tiene cuatro campos
			return;
		}
		if (Funciones.ipRangosBien(ip)==false) {//comprueba que los numeros de la ip esten entre el 255 y el 0
			return;
		}
		System.out.println(args[0]+"/"+args[1]);
		Funciones.clase(ip, cidr1);
	}
		
	
}
