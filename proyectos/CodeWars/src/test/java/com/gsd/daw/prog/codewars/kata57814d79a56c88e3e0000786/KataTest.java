package com.gsd.daw.prog.codewars.kata57814d79a56c88e3e0000786;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class KataTest {

	@Test
	public void testEncrypt() {
		assertEquals("This is a test!", Kata.encrypt("This is a test!", 0));
		assertEquals("hsi  etTi sats!", Kata.encrypt("This is a test!", 1));
		assertEquals("s eT ashi tist!", Kata.encrypt("This is a test!", 2));
		assertEquals(" Tah itse sits!", Kata.encrypt("This is a test!", 3));
		assertEquals("This is a test!", Kata.encrypt("This is a test!", 4));
		assertEquals("This is a test!", Kata.encrypt("This is a test!", -1));
		assertEquals("hskt svr neetn!Ti aai eyitrsig", Kata.encrypt("This kata is very interesting!", 1));
	}
}
