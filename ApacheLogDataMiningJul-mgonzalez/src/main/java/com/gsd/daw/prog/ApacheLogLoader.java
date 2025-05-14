package com.gsd.daw.prog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApacheLogLoader {

    private static final Logger logger = Logger.getLogger(ApacheLogLoader.class.getName());

    public static void main(String[] args) throws IOException, SQLException {

        // Comprobación de numero de argumentos
        if (args.length > 5) {
            System.err.println("Error: Has puesto demasiados argumentos.");
            return;
        }
        if (args.length < 5) {
            int argsNum = 5 - args.length;
            if (argsNum == 1) {
                System.err.println("Error: Te falta " + argsNum + " dato: ");
            } else {
                System.err.println("Error: Te faltan " + argsNum + " datos: ");
            }
            return;
        }

        // Leer la variable de entorno LOG_LEVEL
        String logLevelEnv = System.getenv("LOG_LEVEL");
        if (logLevelEnv != null) {
            try {
                Level logLevel = Level.parse(logLevelEnv);
                logger.setLevel(logLevel);
                ConsoleHandler consoleHandler = new ConsoleHandler();
                consoleHandler.setLevel(logLevel);
                logger.addHandler(consoleHandler);
                logger.info("LogLevel forzado a [" + logLevel + "]");
            } catch (IllegalArgumentException e) {
                System.err.println("Error: Nivel de log no válido: " + logLevelEnv);
            }
        }

        // Creacion de la conexión y comprobar ip
        String ip = args[0];
        if (!CompArgs.compIp(ip)) {
            logger.severe("Error: La ip no es correcta");
            return;
        }

        String nombre = args[1];
        String url = "jdbc:oracle:thin:@//" + ip + "/" + nombre;
        String user = args[2];
        String contra = args[3];
        String logFile = args[4];

        // Intentar conectar a la base de datos
        try (Connection conn = DriverManager.getConnection(url, user, contra)) {
            jdbcDemo(conn);
        } catch (SQLException e) {
            logger.severe("ERROR: excepción SQL: " + e.getMessage());
            return;
        }
        logger.info("INFO: conectado a BBDD.");

        // Lectura de datos y número de líneas leídas del fichero
        String[][] fichDatos = FicheroRecoger.SepararEnArray(logFile);
        int numLineas = FicheroRecoger.contarLineas(logFile);
        logger.info("INFO: leidas [" + numLineas + "] lineas del fichero.");

        // Conversión a objetos del modelo
        List<LineaLog> logsLista = new ArrayList<>();
        for (int i = 0; i < fichDatos.length; i++) {
            if (fichDatos[i][0] == null) {
                break;
            }
            LineaLog l = new LineaLog(fichDatos[i][0], fichDatos[i][1], fichDatos[i][2], fichDatos[i][3],
                    fichDatos[i][4], fichDatos[i][5]);
            logsLista.add(l);
        }
        logger.info("INFO: creados [" + logsLista.size() + "] objetos del modelo.");

        // Guardado en la base de datos
        Connection conn = DriverManager.getConnection(url, user, contra);
        int filasInsertadas = 0;
        for (LineaLog l : logsLista) {
            //logger.fine("FINE: Insertando linea con timestamp: " + l.getTimestamp());
            l.save(conn);
            filasInsertadas++;
        }
        logger.info("INFO: insertadas [" + filasInsertadas + "] filas en BBDD.");
    }

    private static void jdbcDemo(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        conn.setAutoCommit(true);
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM APACHE_LOG_TBL");
        while (resultSet.next()) {
            // Aquí se puede agregar lógica para procesar los resultados si es necesario
        }
        resultSet.close();
        stmt.close();
        conn.close();
    }
}