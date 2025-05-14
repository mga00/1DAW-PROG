package com.gsd.daw.prog;


import com.gsd.daw.prog.figuras.Circulo;
import com.gsd.daw.prog.figuras.Color;
import com.gsd.daw.prog.figuras.Contenedor;
import com.gsd.daw.prog.figuras.Elipse;
import com.gsd.daw.prog.figuras.Linea;
import com.gsd.daw.prog.figuras.LineaPoligonal;
import com.gsd.daw.prog.figuras.Punto;
import com.gsd.daw.prog.figuras.Rectangulo;
import com.gsd.daw.prog.figuras.Stroke;
import com.gsd.daw.prog.figuras.Triangulo;
import com.gsd.daw.prog.figuras.Poligono;
import com.gsd.daw.prog.figuras.TrianguloEquilatero;
 
public class App {
 
	public static void main(String[] args) {
		byte green  = (byte) 122;
		//j
	
		byte red  = (byte) 22;
		byte blue  = (byte) 44;
		Color c1 = new Color(red,green,blue);
		Color c2 = new Color((byte)100,(byte)100,(byte)0);
		c1.toString();
		Punto p1=new Punto(10,343);
		Punto p2=new Punto(50,50);
		Punto p3=new Punto(34,344);
		Punto p4=new Punto(22,2);
		Punto p5=new Punto(33,43);
		Punto p6=new Punto(12,6);
		Rectangulo r1= new Rectangulo(p1,1,1);
		Linea l1=new Linea(p1,p2);
		Punto [] puntos= {p1,p2,p3,p4,p5,p6};
		LineaPoligonal lp1=new LineaPoligonal(puntos);
		Stroke str=new Stroke(c2,(Integer)5);
		lp1.setStroke(str);
		Circulo ci1=new Circulo(p1,10);
		Punto[] puntos1= {p1,p2,p3};
		Triangulo t1=new Triangulo(puntos1);
		Poligono po1=new Poligono(puntos);
		TrianguloEquilatero te1=new TrianguloEquilatero(p2,10);
		Elipse e1=new Elipse(p1,50,50);
		Contenedor contenedor =new Contenedor(500, 500);
		contenedor.addCirculo(ci1);
		contenedor.addElipse(e1);
		contenedor.addLinea(l1);
		contenedor.addLineaPoligonal(lp1);
		contenedor.addPoligono(po1);
		contenedor.addRectangulo(r1);
		contenedor.addTriangulo(t1);
		contenedor.addTrianguloEquilatero(te1);
		System.out.println(contenedor.toSvg());
	}
	
}
