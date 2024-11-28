package com.gsd.daw.prog.matrices;

import java.util.Arrays;

public class Matrices {
	private int [][] matriz;
	
	public int[][] getMatriz() {
		return matriz;
	}

	public Matrices(int[][] matriz) {
		if(!isMatrizValida()) {
			throw new IllegalArgumentException("Las matrices deben ser al menos de 1x1");
		}
		this.matriz=matriz;
	}
	
	
	public int filas() {
		return this.matriz.length;
	}
	
	public int columnas() {
		return this.matriz[0].length;
	}
	
	public boolean mismaDimension(Matrices b) {
		return this.matriz.length==b.matriz.length && this.matriz[0].length==b.matriz[0].length;
	}
	
	public  boolean isMatrizValida() {
		if(filas()<=0) {
				return false;
		}
		for (int i=0; i <= this.matriz.length-1; i++) {
			if(this.matriz[i].length-1<0) {
				return false;
			}
			if(this.matriz[i].length==0) {
				return false;
			}
			if(this.matriz[i].length!=columnas()) {
				return false;
			}
			
		}
		return true;
		}
	
	public Matrices crearSuma(Matrices b) {
		if(!mismaDimension(b)) {
			throw new IllegalArgumentException("Las dimensiones de los arrays no son iguales");
		}
		int [][] c=new int [filas()][columnas()];
		for (int i = 0; i < filas(); i++) {
			for (int j = 0; j < columnas(); j++) {
				c[i][j]=this.matriz[i][j]+b.matriz[i][j];
			}
		}
		return new Matrices(c);
	}
	
	public Matrices crearTranspuesta() {
		int [][] c=new int [columnas()][filas()];
		for (int i = 0; i < filas(); i++) {
			for (int j = 0; j < columnas(); j++) {
				c[i][j]=this.matriz[j][i];
			}
		}
		return new Matrices(c);
	}
	
	@Override
	public String toString() {
		String fin= "";
		for (int i = 0; i < this.matriz.length; i++) {
			for (int j = 0; j < this.matriz[i].length; j++) {
				if(j!=this.matriz[i].length-1) {
					fin+=this.matriz[i][j]+" ";
				}else
					fin+=this.matriz[i][j];
			}
			if(i<=this.matriz.length-1) {
				fin+="\n";	
			}
		}
		return fin;
	}

	public void incrementar(int num) {
		for (int i = 0; i < filas(); i++) {
			for (int j = 0; j < columnas(); j++) {
				matriz[i][j]+=num;
			}
		}
	}
	
	public Matrices crearIncrementada(int num) {
		int [][] c=new int [filas()][columnas()];
		for (int i = 0; i < filas(); i++) {
			for (int j = 0; j < columnas(); j++) {
				c[i][j]=this.matriz[i][j]+=num;
			}
		}
		return new Matrices(c);
	}

	public int getMaximoElemento() {
		int maximo=Integer.MIN_VALUE;
		for (int i = 0; i < filas(); i++) {
			for (int j = 0; j < columnas(); j++) {
				if(this.matriz[i][j]>maximo) {
					maximo=this.matriz[i][j];
				}
			}
		}
		return maximo;
	}

	public int[] getPosicionMaximoElemento() {
		for (int i = 0; i < filas(); i++) {
			for (int j = 0; j < columnas(); j++) {
				getMaximoElemento();
				if(this.matriz[i][j]== getMaximoElemento()) {
					return new int [] {i,j};
				}
			}
		}
		return null;
	}

	public void sumar(Matrices b) {
		for (int i = 0; i < filas(); i++) {
			for (int j = 0; j < columnas(); j++) {
				this.matriz[i][j]+=b.matriz[i][j];
			}
		}
	}
	
}
