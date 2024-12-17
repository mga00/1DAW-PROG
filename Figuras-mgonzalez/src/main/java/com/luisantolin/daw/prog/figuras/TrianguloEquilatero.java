package com.luisantolin.daw.prog.figuras;

public class TrianguloEquilatero {
	private Punto origen;
	private Integer tamanoLado;
	private Stroke stroke;
	public TrianguloEquilatero(Punto origen, Integer tamanoLado) {
		this.origen = origen;
		this.tamanoLado = tamanoLado;
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

	public void setOrigen(Punto origen) {
		if(origen==null) {
			throw new IllegalArgumentException("El punto de origen no puede ser null");
		}
		this.origen = origen;
	}

	public Punto getOrigen() {
		return origen;
	}

	public Integer getTamanoLado() {
		return tamanoLado;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setTamanoLado(Integer tamanoLado) {
		if(tamanoLado==null) {
			throw new IllegalArgumentException("El tamaño del lado del triangulo no puede ser null");
		}
		this.tamanoLado = tamanoLado;
	}
	public String toSvg() {
		return "<polygon points=\""+getOrigen().getX()+","+getOrigen().getY()+
				","+(getOrigen().getX()+tamanoLado)+","+getOrigen().getY()+","+
				((getOrigen().getX()+tamanoLado)/2)+","+(getOrigen().getY()-
						(tamanoLado*Math.sqrt(3))/2)+"\" stroke=\""+stroke.toSvg()+
				"\" stroke-width=\""+stroke.getWidth()+"\" fill=\"none\"/>";
	}
}
