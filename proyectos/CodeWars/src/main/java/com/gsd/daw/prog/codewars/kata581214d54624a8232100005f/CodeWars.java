package com.gsd.daw.prog.codewars.kata581214d54624a8232100005f;

/** Function receive a two-dimensional square array of random integers. On the main diagonal, all the negative integers must be changed to 0, while the others must be changed to 1 (Note: 0 is considered non-negative, here).
<p>
(You can mutate the input if you want, but it is a better practice to not mutate the input)
*/
public class CodeWars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Notas: ojo que no se comprueba que sea rectangular, ni nulls
	 * @param array
	 * @return
	 */
	public static int[][] matrix(int[][] array) {
		int[][] mutada = new int[array.length][array[0].length];

		for (int i = 0; i < mutada.length; i++) {
			for (int j = 0; j < mutada[0].length; j++) {
				if (i == j) {
					if (array[i][j] < 0) {
						mutada[i][j] = 0;
					} else {
						mutada[i][j] = 1;
					}
				} else {
					mutada[i][j] = array[i][j];
				}
			}
		}
		return mutada;
	}

}
