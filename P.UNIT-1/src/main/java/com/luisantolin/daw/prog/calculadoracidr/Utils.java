package com.luisantolin.daw.prog.calculadoracidr;

public class Utils {

	public static int bitsToInt(boolean bits[]) {
		int longitud = bits.length;
		int resultado = 0;
	
		for (int i = 0; i < longitud; i++) {
			if (bits[i]) {
				resultado += Math.pow(2, longitud - i - 1);
			}
		}
	
		return resultado;
	}

	public static int bitsToIntv2(boolean bits[]) {
		int resultado = 0;
	
		for (int i = 0; i < bits.length; i++) {
			if (bits[bits.length - i - 1]) {
				resultado += Math.pow(2, i);
			}
		}
		return resultado;
	}

	static public String bitsToString(boolean bits[]) {
		String resultado = "";
	
		for (int i = 0; i < bits.length; i++) {
			resultado += (bits[i]) ? "1" : "0";
		}
		return resultado;
	}

	static public boolean[] intToBits(int entero, int longitud) {
		boolean[] bits = new boolean[longitud];
		boolean[] resultado = new boolean[longitud];
	
		int cociente;
		int resto;
		int j = 0;
		do {
			cociente = entero / 2;
			resto = entero % 2;
			entero = cociente;
			bits[j++] = (resto != 0);
		} while (cociente != 0);
	
		// padding
		for (int i = j; i < longitud - j; i++) {
			bits[i] = false;
		}
	
		// invertimos el array
		for (int i = 0; i < longitud; i++) {
			resultado[i] = bits[longitud - i - 1];
		}
	
		return resultado;
	}
}
