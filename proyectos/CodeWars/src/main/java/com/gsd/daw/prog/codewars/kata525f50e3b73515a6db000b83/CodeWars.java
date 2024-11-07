package com.gsd.daw.prog.codewars.kata525f50e3b73515a6db000b83;

/** Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.
Example

Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"

The returned format must be correct in order to complete this challenge.

Don't forget the space after the closing parentheses!

*/
public class CodeWars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String createPhoneNumber(int[] numbers) {
		StringBuilder sb = new StringBuilder();

		sb.append("(");
		for (int i = 0; i <= 2; i++) {
			sb.append(numbers[i]);
		}
		sb.append(") ");
		for (int i = 3; i <= 5; i++) {
			sb.append(numbers[i]);
		}
		sb.append("-");
		for (int i = 6; i <= 9; i++) {
			sb.append(numbers[i]);
		}

		return sb.toString();
	}

}
