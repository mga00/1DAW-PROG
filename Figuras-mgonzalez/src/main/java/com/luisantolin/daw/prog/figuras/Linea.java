package com.luisantolin.daw.prog.figuras;

public class Linea {
	private Punto punto1;
	private Punto punto2;
	private Stroke stroke;
	
	public Linea(Punto punto1, Punto punto2) {
		this.punto1 = punto1;
		this.punto2 = punto2;
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
		Color color=new Color(r,g,b);
		Stroke defecto=new Stroke(color,1);
		return defecto;
	}
	public void setPunto1(Punto punto1) {
		if(punto1==null) {
			throw new IllegalArgumentException("El punto no puede ser null");
		}
		this.punto1 = punto1;
	}

	public void setPunto2(Punto punto2) {
		if(punto2==null) {
			throw new IllegalArgumentException("El punto no puede ser null");
		}
		this.punto2 = punto2;
	}
	public String toSvg() {
		return "<line x1=\""+punto1.getX()+"\" y1=\""+punto1.getY()+"\" x2=\""
	+punto2.getX()+"\" y2=\""+punto2.getY()+"\" stroke=\""+stroke.toSvg()+"\" "
			+ "stroke-width=\""+stroke.getWidth()+"\"/>";
	}
	
}
