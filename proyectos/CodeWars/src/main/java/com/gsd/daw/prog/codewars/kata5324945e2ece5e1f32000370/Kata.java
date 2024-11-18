package com.gsd.daw.prog.codewars.kata5324945e2ece5e1f32000370;

import java.util.Arrays;

public class Kata {

	public static String sumStrings(String a, String b) {
		return new Kata.EnteroPositivoEnorme(a).sumar(new Kata.EnteroPositivoEnorme(b)).toString();
	}

	static class EnteroPositivoEnorme {
		private byte[] digitos;

		public EnteroPositivoEnorme(byte[] digitos) {
			for (int i = 0; i < digitos.length; i++) {

				if (digitos[i] < 0 || digitos[i] > 9) {
					throw new IllegalArgumentException("Alguno de los digitos es mayor que 9 o menor que 0");
				}
			}
			this.digitos = digitos;
		}

		public EnteroPositivoEnorme(String numeroString) {
			digitos = new byte[numeroString.length()];
			for (int i = 0; i < numeroString.length(); i++) {
				char digitoChar = numeroString.charAt(i);
				if (digitoChar < '0' || digitoChar > '9') {
					throw new IllegalArgumentException("El argumento no es un número entero");
				}
				digitos[i] = (byte) (digitoChar - '0');
			}
		}

		public String toString() {
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < digitos.length; i++) {
				s.append(digitos[i]);
			}
			return s.toString();
		}

		// Nota del profesor, abordar el problema en fases
		// 1. sumar sin llevadas numeros de igual longitud
		// 2. sumar sin llevadas numeros de distinta longitud
		// 3. sumar con llevadas, pero que la llevada no esté en la cifra más alta
		// 4. abordar el caso de llevadas en la cifra más alta
		public EnteroPositivoEnorme sumar(EnteroPositivoEnorme e) {
			byte[] sumandoLargo = null;
			byte[] sumandoCorto = null;
			byte[] digitosResultado;
			int longitudSumandoMasLargo;

			if (e.digitos.length < this.digitos.length) {
				longitudSumandoMasLargo = this.digitos.length;
				sumandoLargo = this.digitos;
				sumandoCorto = padWithZeros(e.digitos, longitudSumandoMasLargo);
			} else if (e.digitos.length > this.digitos.length) {
				longitudSumandoMasLargo = e.digitos.length;
				sumandoLargo = e.digitos;
				sumandoCorto = padWithZeros(this.digitos, longitudSumandoMasLargo);
			} else {
				longitudSumandoMasLargo = e.digitos.length;
				sumandoLargo = e.digitos;
				sumandoCorto = this.digitos;
			}

			digitosResultado = new byte[longitudSumandoMasLargo];

			boolean meLlevoUna = false;
			for (int i = longitudSumandoMasLargo - 1; i >= 0; i--) {
				byte suma = (byte) (sumandoLargo[i] + sumandoCorto[i]);
				if (meLlevoUna) {
					suma++;
				}

				if (suma < 10) {
					digitosResultado[i] = suma;
					meLlevoUna = false;
				} else {
					meLlevoUna = true;
					digitosResultado[i] = (byte) (suma - 10);
				}
			}

			// la ultima llevada da lugar a un resultado que es una posicion más largo
			if (meLlevoUna) {
				byte[] resultadoMasLargo = new byte[longitudSumandoMasLargo + 1];
				resultadoMasLargo[0] = 1;
				for (int i = 1; i < resultadoMasLargo.length; i++) {
					resultadoMasLargo[i] = digitosResultado[i - 1];
				}
				digitosResultado = resultadoMasLargo;
			}
			
			// a la kata no le gusta que haya ceros al principio
			byte[] sinCerosAlPrincipio = digitosResultado;
			if ( digitosResultado[0] == 0 ) {
				sinCerosAlPrincipio = Arrays.copyOfRange(digitosResultado, 1, digitosResultado.length);
			}

			return new EnteroPositivoEnorme(sinCerosAlPrincipio);
			
		}

	    public static byte[] padWithZeros( byte[] toPad, int size ) {
	        byte[] padded = new byte[size];
	       
	        int j=0;
	        for ( int i = 0 ; i < size ; i++ ) {
	            if ( i < (size-toPad.length)) {
	                padded[i] = 0;
	                
	            } else {
	                padded[i] = toPad[j++];
	            }
	        }
	        return padded;
	    }
	}
}
