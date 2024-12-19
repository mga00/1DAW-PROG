package com.luisantolin.daw.prog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App2 {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("USO: <comando> <nombre-de-fichero>");
			return;
		}

		Scanner inputScannerFromFile = null;
		File f = new File(args[0]);
		try {
			inputScannerFromFile = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: no se puede abrir [" + args[0] + "]\n" + e.getMessage());
			return;
		}

		while (inputScannerFromFile.hasNext()) {
			String line = inputScannerFromFile.nextLine();
			System.out.println("@@@" + line + "@@@");
		}

		inputScannerFromFile.close();

	}

}
