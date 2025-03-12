package com.gsd.daw.prog.figuras;

public class Elipse {
	private Punto centro;
	private Integer radio1;
	private Integer radio2;
	private Stroke stroke;
	
	public Elipse(Punto centro, Integer radio1, Integer radio2) {
		this.centro = centro;
		this.radio1 = radio1;
		this.radio2 = radio2;
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

	public void setCentro(Punto centro) {
		if(centro==null) {
			throw new IllegalArgumentException("El centro es inválido");
		}
		this.centro = centro;
	}

	public void setRadio1(Integer radio1) {
		if(radio1==null) {
			throw new IllegalArgumentException("El radio1 es inválido");
		}
		this.radio1 = radio1;
	}

	public void setRadio2(Integer radio2) {
		if(radio2==null) {
			throw new IllegalArgumentException("El radio2 es inválido");
		}
		this.radio2 = radio2;
	}
	public String toSvg() {
		return "<ellipse cx=\""+centro.getX()+"\" cy=\""+centro.getY()+"\" rx=\""
	+radio1+"\" ry=\""+radio2+"\" stroke=\""+stroke.toSvg()+"\" stroke-width=\""
				+stroke.getWidth()+"\" fill=\"none\"/>";
	}
	
}
