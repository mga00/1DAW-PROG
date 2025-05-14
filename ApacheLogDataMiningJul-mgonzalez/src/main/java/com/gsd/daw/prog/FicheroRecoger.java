package com.gsd.daw.prog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FicheroRecoger {
	//Crea una clase aparte, cuya responsabilidad sea recibir un nombre de fichero
    // y devolver una estructura String[40000][6] con los datos en columnas
    public static String[][] SepararEnArray(String nombreFich) {
    	String[][] datos = new String [40000][6];
    	BufferedReader br=null;
    	try {
    		br= new BufferedReader(new FileReader(nombreFich));
    		String texto=br.readLine();
    		int contador=0;
    		while (texto != null) {
    			String[] lineas= parseLogLineString(texto);
    			contador++;
    			for(int i=0; i<6; i++) {
    				datos[contador-1][i]= lineas[i];
    				continue;
    			}
    			texto=br.readLine();
			}
    	}catch(FileNotFoundException  e) {
    		System.err.println("Error: Fichero no encontrado");
    	}
    	catch(Exception e) {
    		System.err.println("Error de lectura del fichero");
    	}
    	return datos;
    	//como hacer para que si no se rellenen todos los huecos de la 
    	//matriz lo que no se haya rellenado no ponerlo preguntar si con solo un if
    }
    public static int contarLineas(String fichero) throws IOException {
    	BufferedReader br=null;
    	br= new BufferedReader(new FileReader(fichero));
    	String texto=br.readLine();
    	int contador=0;
    	while (texto != null) {
    		contador++;
    		texto=br.readLine();
    	}
    	return contador;
    }
	public static String[] parseLogLineString( String line ) {
        String  LOG_ENTRY_PATTERN = "^(\\S+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(.+?)\" (\\d{3}) (\\S+) \"(.*?)\" \"(.*?)\"$";
        Pattern pattern = Pattern.compile( LOG_ENTRY_PATTERN );     
        
        String[] res = new String[6];
        Matcher matcher = pattern.matcher( line );
        if ( matcher.matches() ) {
            res[0] = matcher.group( 1 );
            res[1] = matcher.group( 4 );
            res[2] = matcher.group( 5 );
            res[3] = matcher.group( 6 );
            res[4] = matcher.group( 7 );
            res[5] = matcher.group( 9 );
        }
        return res;
    }
	//cada linea del fichero utiliza esta funcion una vez
}
