package com.luisantolin.daw.prog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	public static void main( String[] args ) {
		if (args.length < 1) {
			System.err.println("USO: <comando> <nombre-de-fichero>");
			return;
		}

		Scanner inputFile = null;
		try {
			File f = new File(args[0]);
			inputFile = new Scanner( f );

		} catch (FileNotFoundException e) {
			System.err.println("ERROR: no se puede abrir el fichero [" + args[0] + "]");
			return;
		}
		
        while (inputFile.hasNext()) {
            String line = inputFile.nextLine();
            System.out.println("---" + line + "---");
        }

        inputFile.close();

	}

}
