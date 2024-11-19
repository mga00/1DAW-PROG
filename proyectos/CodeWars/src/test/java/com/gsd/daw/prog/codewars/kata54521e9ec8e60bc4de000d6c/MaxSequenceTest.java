package com.gsd.daw.prog.codewars.kata54521e9ec8e60bc4de000d6c;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaxSequenceTest {
	@Test
	public void testEmptyArray() throws Exception {
		assertEquals(0, Max.sequence(new int[] {}));
	}

	@Test
	public void testExampleArray() throws Exception {
		assertEquals(3, Max.sequence(new int[] { 1, 1, 1 }));
	}

	@Test
	public void testExampleArray2() throws Exception {
		assertEquals(6, Max.sequence(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}
}