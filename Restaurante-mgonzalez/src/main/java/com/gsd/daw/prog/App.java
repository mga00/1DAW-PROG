package com.gsd.daw.prog;
import java.util.Arrays;
import java.util.Scanner;
import com.gsd.daw.prog.api.*;

public class App {
	static int[] mesas =new int[10];
	public static void main(String[] args) {
		
		Restaurante casaPepe =new Restaurante("Casa Pepe", 10);
		Restaurante casaJuan =new Restaurante("Casa Pepe", 20);
		
		casaPepe.sentarMesa(10);
		casaPepe.sentarMesa(9);
		casaPepe.sentarMesa(8);
		casaPepe.sentarMesa(7);
		casaPepe.sentarMesa(6);
		casaPepe.sentarMesa(5);
		casaPepe.sentarMesa(4);
		System.out.println(casaPepe.toString());
		casaPepe.levantarMesa(1);
		casaPepe.levantarMesa(3);
		casaPepe.levantarMesa(5);
		casaPepe.levantarMesa(7);
		System.out.println(casaPepe.toString());
		casaPepe.reagruparMesas();
		System.out.println(casaPepe.toString());
	}	
}
