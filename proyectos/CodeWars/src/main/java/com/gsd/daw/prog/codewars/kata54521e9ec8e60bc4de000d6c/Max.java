package com.gsd.daw.prog.codewars.kata54521e9ec8e60bc4de000d6c;

/**
 * The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:
 * Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
 * // should be 6: {4, -1, 2, 1}
 * Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array. If the list is made up of only negative numbers, return 0 instead.
 * Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
 */
public class Max {
	public static int sequence(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}

		int candidato = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int suma = suma(arr, i, j);
				if (suma > candidato) {
					candidato = suma;
				}
			}
		}

		return candidato;
	}

	static int suma(int[] a, int start, int end) {
		int suma = 0;
		for (int i = start; i <= end; i++) {
			suma += a[i];
		}
		System.out.println(start + "|" + end + "|" + suma);
		return suma;
	}

}
