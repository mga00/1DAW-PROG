package com.gsd.daw.prog.figuras;

public class Triangulo {
	private Punto[] puntos;
	private Stroke stroke;
	
	public Triangulo(Punto[] puntos) {
		this.puntos = puntos;
		this.stroke=strokeDefecto();
	}
	
	public void setStroke(Stroke stroke) {
		if(stroke==null) {
			throw new IllegalArgumentException("El stroke es inválido");
		}
		this.stroke=stroke;
	}
	
	public Punto[] getPuntos() {
		return puntos;
	}

	public Stroke getStroke() {
		return stroke;
	}
	public Stroke strokeDefecto() {
		Byte r=0;
		Byte g=0;
		Byte b=0;
		Color color=new Color(r,g,b);
		Stroke defecto=new Stroke(color,1);
		return defecto;
	}
	public void setPuntos(Punto[] puntos) {
		if(puntos==null || puntos.length !=3) {
			throw new IllegalArgumentException("Los puntos no puenden ser null ni ser menos que tres");
		}
		for (int i = 0; i < puntos.length; i++) {
			if(puntos[i]==null) {
				throw new IllegalArgumentException("Un punto no puende ser null");
			}
		}
		this.puntos = puntos;
	}
	public String toSvg() {
		String nuevo="";
		for (int i = 0; i < puntos.length; i++) {
			nuevo+=(puntos[i].getX()+" "+puntos[i].getY()+" ");
		}
		return "<polygon points=\""+nuevo+"\" stroke=\""+stroke.toSvg()+"\" stroke-width=\""+stroke.getWidth()+"\" fill=\"none\"/>";
	}
}
