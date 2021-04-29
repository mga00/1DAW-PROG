package com.luisantolin.daw.prog.calculadoracidr;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MainTest {
	@Test
	void mainTest( ) {
		String[] args = new String[]{ "172.16.7.200", "22" };
		CalculadoraCIDR.main( args );
		assertTrue( true );
	}
}
