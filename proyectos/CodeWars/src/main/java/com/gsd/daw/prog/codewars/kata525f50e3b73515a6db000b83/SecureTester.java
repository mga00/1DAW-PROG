package com.gsd.daw.prog.codewars.kata525f50e3b73515a6db000b83;

/** In this example you have to validate if a user input string is alphanumeric. The given string is not nil/null/NULL/None, so you don't have to check that.

The string has the following conditions to be alphanumeric:

    At least one character ("" is not valid)
    Allowed characters are uppercase / lowercase latin letters and digits from 0 to 9
    No whitespaces / underscore


*/
public class SecureTester {

	public static boolean alphanumeric(String s) {
		char[] cs = s.toCharArray();

		if (cs.length < 1)
			return false;

		for (int i = 0; i < cs.length; i++) {
			char c = cs[i];
			if (!((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)))
				return false;
		}
		return true;
	}

}