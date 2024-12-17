package com.luisantolin.daw.prog.figuras;

public class Rectangulo {
	private Punto origen;
	private Integer ancho;
	private Integer alto;
	private Stroke stroke;
	
	public Rectangulo(Punto origen, Integer ancho, Integer alto) {
		this.origen = origen;
		this.ancho = ancho;
		this.alto = alto;
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

	public Punto getOrigen() {
		return origen;
	}

	public Integer getAncho() {
		return ancho;
	}

	public Integer getAlto() {
		return alto;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setOrigen(Punto origen) {
		if(origen==null) {
			throw new IllegalArgumentException("El punto de origen no puede ser null");
		}
		this.origen = origen;
	}

	public void setAncho(Integer ancho) {
		if(ancho==null) {
			throw new IllegalArgumentException("El ancho del contenedor no puede ser null");
		}
		this.ancho = ancho;
	}

	public void setAlto(Integer alto) {
		if(alto==null) {
			throw new IllegalArgumentException("El alto del contenedor no puede ser null");
		}
		this.alto = alto;
	}
	public String toSvg() {
		return"<rect x=\""+origen.getX()+"\" y=\""+origen.getY()+"\" width=\""
	+getAncho()+"\" height=\""+getAlto()+"\" stroke=\""+stroke.toSvg()+"\" "
			+ "stroke-width=\""+stroke.getWidth()+"\" fill=\"none\"/>";
	}
}
