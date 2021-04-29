package com.luisantolin.daw.prog.calculadoracidr;

import java.util.Arrays;

public class Ip {
	// TODO: esto debería ser un enumerado
	static final public String CLASE_A = "A";
	static final public String CLASE_B = "B";
	static final public String CLASE_C = "C";
	static final public String CLASE_D = "D";
	static final public String CLASE_DESCONOCIDA = "E";

	private boolean bitsIp[];
	private int mascara;

	public Ip(String miIp, String miMascara) throws IllegalArgumentException {
		try {
			mascara = Integer.parseInt(miMascara);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Máscara invalida. Tiene que ser un entero entre 1 y 32");
		}

		if (mascara < 1 || mascara > 32) {
			throw new IllegalArgumentException("Máscara invalida. Tiene que ser un entero entre 1 y 32");
		}

		String bytes[] = miIp.split("\\.");

		if (bytes.length != 4) {
			throw new IllegalArgumentException("IP invalida, no parece tener cuatro cifras separadas por puntos");
		}

		if (bytes[0].length() == 0 || bytes[1].length() == 0 || bytes[2].length() == 0 || bytes[3].length() == 0) {
			throw new IllegalArgumentException("IP invalida, alguna de las cifras está vacía.");
		}

		int byte1 = 0;
		int byte2 = 0;
		int byte3 = 0;
		int byte4 = 0;
		try {
			byte1 = Integer.parseInt(bytes[0]);
			byte2 = Integer.parseInt(bytes[1]);
			byte3 = Integer.parseInt(bytes[2]);
			byte4 = Integer.parseInt(bytes[3]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Alguno de los bytes de la IP no es un numero entero");
		}

		if (byte1 < 1 || byte1 > 254) {
			throw new IllegalArgumentException("IP invalida. El 1er byte no puede ser ni <1 ni >254");
		}
		if (byte2 < 0 || byte2 > 255) {
			throw new IllegalArgumentException("IP invalida. El 2o byte no puede ser ni <0 ni >255");
		}
		if (byte3 < 0 || byte3 > 255) {
			throw new IllegalArgumentException("IP invalida. El 3er byte no puede ser ni <0 ni >255");
		}
		if (byte4 < 0 || byte4 > 255) {
			throw new IllegalArgumentException("IP invalida. El 4o byte no puede ser ni <0 ni >255");
		}

		boolean bits1[] = Utils.intToBits(byte1, 8);
		boolean bits2[] = Utils.intToBits(byte2, 8);
		boolean bits3[] = Utils.intToBits(byte3, 8);
		boolean bits4[] = Utils.intToBits(byte4, 8);

		bitsIp = new boolean[32];
		System.arraycopy(bits1, 0, bitsIp, 0, 8);
		System.arraycopy(bits2, 0, bitsIp, 8, 8);
		System.arraycopy(bits3, 0, bitsIp, 16, 8);
		System.arraycopy(bits4, 0, bitsIp, 24, 8);
	}

	public Ip(Ip ip) {
		this.bitsIp = Arrays.copyOf(ip.bitsIp, ip.bitsIp.length);
		this.mascara = ip.mascara;
	}
	
	public int getMascara() {
		return mascara;
	}	

	public int getByte(int n) {
		boolean bits[];
		if (n == 1) {
			bits = Arrays.copyOfRange(bitsIp, 0, 8);
		} else if (n == 2) {
			bits = Arrays.copyOfRange(bitsIp, 8, 16);
		} else if (n == 3) {
			bits = Arrays.copyOfRange(bitsIp, 16, 24);
		} else if (n == 4) {
			bits = Arrays.copyOfRange(bitsIp, 24, 32);
		} else {
			throw new IllegalArgumentException("El numero de byte tiene que estar entre 1 y 4");
		}

		return Utils.bitsToInt(bits);
	}

	public boolean getBit(int posicion) {
		if (posicion < 0 || posicion > 31) {
			throw new IllegalArgumentException("Posicion invalida, no puede ser ni <0 ni >31");
		}
		return bitsIp[posicion];
	}

	public void setBit(int posicion, boolean bit) {
		if (posicion < 0 || posicion > 31) {
			throw new IllegalArgumentException("Posicion invalida, no puede ser ni <0 ni >31");
		}
		bitsIp[posicion] = bit;

		// TODO: validar que el bit nuevo no produzca una IP invalida
	}

	public String toString() {
		return getByte(1) + "." + getByte(2) + "." + getByte(3) + "." + getByte(4);
	}

	public String calculaDireccionDeRed() {
		Ip red = new Ip(this);

		for (int i = 31; i >= mascara; i--) {
			red.setBit(i, false);
		}
		return red.toString();
	}

	public String getClase() {
		int byte1 = getByte(1);

		if (byte1 <= 127) {
			return CLASE_A;
		}
		if (byte1 <= 191) {
			return CLASE_B;
		}
		if (byte1 <= 223) {
			return CLASE_C;
		}
		if (byte1 < 239) {
			return CLASE_D;
		}
		return CLASE_DESCONOCIDA;
	}
}
