package com.luisantolin.daw.prog.figuras;

public class Stroke {
	private Color color;
	private Integer width;

	public Stroke(Color color, Integer width) {
		this.color = color;
		this.width = width;
	}
	
	public void setColor(Color color) {
		if(color==null) {
			throw new IllegalArgumentException("El color no puede ser null");
		}
		this.color = color;
	}

	public void setWidth(Integer width) {
		if(width==null) {
			throw new IllegalArgumentException("El grosor no puede ser null");
		}
		this.width = width;
	}

	public Color getColor() {
		return color;
	}

	public Integer getWidth() {
		return width;
	}
	public String toSvg() {
		return ""+color.toSvg()+"";
	}
}
