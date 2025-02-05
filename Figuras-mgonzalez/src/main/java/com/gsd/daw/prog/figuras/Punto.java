package com.gsd.daw.prog.figuras;

public class Punto {
	private Integer x;
	private Integer y;
	
	public Punto(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	public void setX(Integer x) {
		if(x==null) {
			throw new IllegalArgumentException("La coordenada x no puede ser null");
		}
		this.x = x;
	}
	public void setY(Integer y) {
		if(y==null) {
			throw new IllegalArgumentException("La coordenada y no puede ser null");
		}
		this.y = y;
	}
	public Integer getX() {
		return x;
	}
	public Integer getY() {
		return y;
	}
	
	
}
