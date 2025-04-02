package com.gsd.daw.prog.figuras;

public class Color {
	private int red;
	private int green;
	private int blue;
	
	public Color(Byte red, Byte green, Byte blue) {
		this.red = byteToUnsignedInt(red);
		this.green = byteToUnsignedInt(green);
		this.blue = byteToUnsignedInt(blue);
	}
	
	public void setRed(Byte red) {
		if(red==null || red<0 || red>255 || red==null) {
			throw new IllegalArgumentException("El valor de rojo tiene que estar entre 0 y 255");
		}
		this.red = byteToUnsignedInt(red);
	}
	private int byteToUnsignedInt(Byte value) {
		return value & 0xFF;
	}

	public void setGreen(Byte green) {
		if(green==null || green<0 || green>255 || green==null) {
			throw new IllegalArgumentException("El valor de verde tiene que estar entre 0 y 255");
		}
		this.green = byteToUnsignedInt(green);
	}
	public void setBlue(Byte blue) {
		if(blue==null || blue<0 || blue>255 || blue==null) {
			throw new IllegalArgumentException("El valor de azul tiene que estar entre 0 y 255");
		}
		this.blue = byteToUnsignedInt(blue);
	}
	
	public String toSvg() {
		return "rgb("+Byte.toUnsignedInt((byte) red)+","+Byte.toUnsignedInt((byte) green)+","+Byte.toUnsignedInt((byte) blue)+")";
	}
	
}
