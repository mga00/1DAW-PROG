package com.gsd.daw.prog.codewars.katacom.gsd.daw.prog.codewars.kata581214d54624a8232100005f;

import java.util.Arrays;

public class Solution {
	public static String camelCase(String str) {
		int j = 0;

		char[] chars = str.toCharArray();
		char[] res = new char[str.length()];
		boolean spaceFound = true;
		for (int i = 0; i < chars.length; i++) {

			if (chars[i] == ' ') {
				spaceFound = true;
				continue;
			}
			if (spaceFound) {
				res[j++] = Character.toUpperCase(str.charAt(i));
				spaceFound = false;
			} else {
				res[j++] = chars[i];
			}

		}
		return String.valueOf(Arrays.copyOf(res, j));
	}

	public static void main(String[] args) {
		System.out.println(Solution.camelCase("camel case method"));
		System.out.println("[" + Solution.camelCase("test case") + "]");
	}

}
