package com.gsd.daw.prog.matrices;

import java.util.Arrays;
import java.util.Iterator;

public class Matriz {
	//Esta funcion comprueba si dos matrices tiene la misma dimension.
	public static boolean mismaDimension (int[][] a, int[][] b) {
		if(a.length!=b.length) {
			return false;
		}
		if(a[0].length!=b[0].length) {
			return false;
		}
		return true;
	}
	//La siguiente función suma dos matrices creando una nueva matriz con el resultado
	//solo si tienen la misma dimension y son validas las dos matrices.
	public static int[][] crearSuma(int[][] a, int[][] b){
		if(!isMatrizValida(a) || !isMatrizValida(b) || !mismaDimension(a,b)) {
			return null;
		}
		int [][] c=new int [a.length][a[0].length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				c[i][j]=a[i][j]+b[i][j];
			}
		}
		return c;
	}
	//L siguiente funcion suma dos matrices alterando la primera matriz
	public static void sumar(int[][] a,int[][] b) {
		if(!isMatrizValida(a) || !isMatrizValida(b) || !mismaDimension(a,b)) {
			return;
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j]+=b[i][j];
			}
		}
	}
	//La siguiente funcion comprueba si una matriz es valida.
	public static boolean isMatrizValida(int[][] m) {
		if(m==null) {
			return false;
		}
		if(m.length<=0) {
				return false;
		}
		for (int i=0; i <= m.length-1; i++) {
			if(m[i]==null || m[i].length-1<0) {
				return false;
			}
			if(m[i].length==0) {
				return false;
			}
			if(m[i].length!=m[0].length) {
				return false;
			}
			
		}
		return true;
		}
	
	//La siguiente funcion pasa la matriz a string.
	public static String toString(int[][] m) {
		if(!isMatrizValida(m)) {
			return null;
		}
		String fin= "";
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if(j!=m[i].length-1) {
					fin+=m[i][j]+" ";
				}else
					fin+=m[i][j];
			}
			if(i<=m.length-1) {
				fin+="";	
			}
		}
		return fin;
	}
//Esta funcion crea la matriz traspuesta de otra matriz
	/**El reto no se puede hacer porque daria un out of 
	 * bounds dado que la matriz es estatica y no se puden cambiar las dimensiones de esta 
	 */
	public static int[][] crearTraspuesta(int[][] m){
		if(!isMatrizValida(m)) {
			return null;
		}
	int [][] c=new int [m[0].length][m.length];
	for (int i = 0; i < m.length; i++) {
		for (int j = 0; j < m[i].length; j++) {
			c[j][i]=m[i][j];
		}
	}
	return c;
	}
	//Esta funcion incrementa o decrementa los valores de la matriz dada.
	public static void incrementar(int[][] m,int incremento) {
		if(!isMatrizValida(m)) {
			return;
		}
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j]+=incremento;
			}
		}
	}
	//Esta funcion incrementa o decrementa los valores de la matriz dada creando una nueva matriz.
	public static int [][] crearIncrementada(int[][] m,int incremento) {
		if(!isMatrizValida(m)) {
			return null;
		}
		int [][] c=new int [m.length][m[0].length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				c[i][j]=m[i][j]+incremento;
			}
		}
		return c;
	}
	//Esta funcion obtiene el valor más grande de la matriz
	public static int getMaximoElemento(int[][] m) {
		if(!isMatrizValida(m)) {
			return  Integer.MIN_VALUE;
		}
		int maximo=Integer.MIN_VALUE;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if(m[i][j]>maximo) {
					maximo=m[i][j];
				}
			}
		}
		return maximo;
	}
	//Esta funcion haya ela posicion del elemento más grande
	public static int[] getPosicionMaximoElemento(int[][] m) {
		if(!isMatrizValida(m)) {
			return  null;
		}
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				getMaximoElemento(m);
				if(m[i][j]== getMaximoElemento(m)) {
					return new int [] {i,j};
				}
			}
		}
		return null;
	}
}

