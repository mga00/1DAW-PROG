package com.gsd.daw.prog.ApacheAnalizer;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FicheroRecoger {
	//Crea una clase aparte, cuya responsabilidad sea recibir un nombre de fichero
    // y devolver una estructura String[40000][6] con los datos en columnas
    private Map<String, String> logs = new HashMap<>();
	public static String[] parseLogLineString( String line ) {
        String  LOG_ENTRY_PATTERN = "^(\\S+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(.+?)\" (\\d{3}) (\\S+) \"(.*?)\" \"(.*?)\"$";
        Pattern pattern           = Pattern.compile( LOG_ENTRY_PATTERN );     
        
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
	//cafda linea de lfichero utiliza esta funcion una vez
}
