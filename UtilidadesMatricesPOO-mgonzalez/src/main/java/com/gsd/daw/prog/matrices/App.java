package com.gsd.daw.prog.matrices;

public class App {

	public static void main(String[] args) {
		int[][] a = {
	            {1, 2, 3},
	            {4, 5, 6}
	        };
	        int[][] b = {
	            {1, 2, 3},
	            {4, 5, 6}
	        };
	        Matrices m1= new Matrices(a);
	        Matrices m2=new Matrices(b);
	        m1.sumar(m2);
	        System.out.println(m1);
	}

}
