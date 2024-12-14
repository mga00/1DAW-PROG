package com.gsd.daw.prog.codewars.kata513e08acc600c94f01000001;

public class RgbToHex {

	public static String rgb(int r, int g, int b) {
		if (r < 0)
			r = 0;
		if (r > 255)
			r = 255;
		if (g < 0)
			g = 0;
		if (g > 255)
			g = 255;
		if (b < 0)
			b = 0;
		if (b > 255)
			b = 255;

		return String.format("%02x%02x%02x", r, g, b).toUpperCase();
	}
}
