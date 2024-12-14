package com.gsd.daw.prog.codewars.kata525f50e3b73515a6db000b83;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/** In this example you have to validate if a user input string is alphanumeric. The given string is not nil/null/NULL/None, so you don't have to check that.

The string has the following conditions to be alphanumeric:

    At least one character ("" is not valid)
    Allowed characters are uppercase / lowercase latin letters and digits from 0 to 9
    No whitespaces / underscore


*/
public class SecureTesterTest {

	@Test
	@DisplayName("Valid input")
	void testValidInput() {
		assertTrue(SecureTester.alphanumeric("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
	}

	@DisplayName("Invalid character")
	@ParameterizedTest(name = "Should return false for \"{0}\"")
	@ValueSource(strings = { "", "with space", "with_underscore", "punctuation.", "naïve", "１strangedigit", "emoji😊" })
	void testInvalidChars(String input) {
		assertFalse(SecureTester.alphanumeric(input));
	}

}