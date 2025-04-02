package com.gsd.daw.prog.figuras;

public class Circulo {
	private Punto centro;
	private Integer radio;
	private Stroke stroke;
	
	public Circulo(Punto centro, Integer radio) {
		this.centro = centro;
		this.radio = radio;
		this.stroke=strokeDefecto();
	}
	
	public void setStroke(Stroke stroke) {
		if(stroke==null) {
			throw new IllegalArgumentException("El stroke es inválido");
		}
		this.stroke=stroke;
	}
	public Stroke strokeDefecto() {
		Byte r=0;
		Byte g=0;
		Byte b=0;
		Color color=new Color((byte)r ,(byte)g ,(byte)b );
		Stroke defecto=new Stroke(color,1);
		return defecto;
	}
	public void setCentro(Punto centro) {
		if(centro==null) {
			throw new IllegalArgumentException("El centro es inválido");
		}
		this.centro = centro;
	}

	public void setRadio(Integer radio) {
		if(radio==null) {
			throw new IllegalArgumentException("El radio1 es inválido");
		}
		this.radio = radio;
	}
	
	public Punto getCentro() {
		return centro;
	}

	public Integer getRadio() {
		return radio;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public String toSvg() {
		return "<circle cx=\""+centro.getX()+"\" cy=\""+centro.getY()+"\" r=\""
	+getRadio()+"\" stroke=\""+stroke.getColor().toSvg()+"\" stroke-width=\""+stroke.getWidth()+""
			+ "\" fill=\"none\"/>";
	}
	
}
