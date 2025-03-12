package com.gsd.daw.prog.matrices;

public class App {

	public static void main(String[] args) {
		int[][] a = {
	            {1, 2, 3},
	            {4, 5, 6}
	        };
	        int[][] b = {
	            {7, 8, 9},
	            {10, 11, 12}
	        };
	        Matriz.sumar(a, b);
	        System.out.println(Matriz.toString(a));
	}

}
