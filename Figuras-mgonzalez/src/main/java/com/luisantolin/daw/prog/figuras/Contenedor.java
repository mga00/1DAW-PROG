package com.luisantolin.daw.prog.figuras;

public class Contenedor {
	private Integer ancho;
	private Integer alto;
	private Circulo circuloSvg;
	private Elipse elipseSvg;
	private Linea lineaSvg;
	private LineaPoligonal lineaPoligonalSvg;
	private Poligono poligonoSvg;
	private Rectangulo rectanguloSvg;
	
	public Contenedor(Integer ancho, Integer alto) {
		this.ancho = ancho;
		this.alto = alto;
		this.circuloSvg=null;
		
	}
	public Circulo getCirculo() {
		return circuloSvg;
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
	
	public void addCirculo(Circulo figura) {
		if(figura==null) {
			throw new IllegalArgumentException("El circulo a añador no puede ser null");
		}
		this.circuloSvg=figura;
	}
	
	public void addElipse(Elipse figura) {
		if(figura==null) {
			throw new IllegalArgumentException("La elipse a añador no puede ser null");
		}
		this.elipseSvg=figura;
	}
	
	public Integer getAncho() {
		return ancho;
	}

	public Integer getAlto() {
		return alto;
	}

	public void addLinea(Linea figura) {
		if(figura==null) {
			throw new IllegalArgumentException("La linea a añador no puede ser null");
		}
		this.lineaSvg=figura;
	}
	
	public void addLineaPoligonal(LineaPoligonal figura) {
		if(figura==null) {
			throw new IllegalArgumentException("La linea poligonal a añador no puede ser null");
		}
		this.lineaPoligonalSvg=figura;	}
	
	public void addPoligono(Poligono figura) {
		if(figura==null) {
			throw new IllegalArgumentException("El poligono a añador no puede ser null");
		}
		this.poligonoSvg=figura;
	}
	
	public void addRectangulo(Rectangulo figura) {
		if(figura==null) {
			throw new IllegalArgumentException("El rectangulo a añador no puede ser null");
		}
		this.rectanguloSvg=figura;
	}
	
	public String toSvg() {
		return "<svg viewBox=\"0 0 "+getAncho()+" "+getAlto()+"\" xmlns=\"http://www.w3.org/2000/svg\">\n"+circuloSvg.toSvg()+
				"\n"+elipseSvg.toSvg()+"\n"+lineaSvg.toSvg()+"\n"+lineaPoligonalSvg.toSvg()+"\n"+poligonoSvg.toSvg()+
				"\n"+rectanguloSvg.toSvg()+"\n"+"</svg>";
	}
	
}
