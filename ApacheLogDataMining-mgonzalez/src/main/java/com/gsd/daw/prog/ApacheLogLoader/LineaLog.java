package com.gsd.daw.prog.ApacheLogLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LineaLog {
	private String ip;
	private String fecha;
	private String direccion;
	private String numError;
	private String idError;
	private String navegador;
	
	public LineaLog(String ip, String fecha, String direccion, 
			String numError, String idError, String navegador) {
		this.ip = ip;
		this.fecha = fecha;
		this.direccion = direccion;
		this.numError = numError;
		this.idError = idError;
		this.navegador = navegador;
	}

	public String getIp() {
		return ip;
	}

	public String getFecha() {
		return fecha;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getNumError() {
		return numError;
	}

	public String getIdError() {
		return idError;
	}

	public String getNavegador() {
		return navegador;
	}
	// La clase del modelo debe tener un método save( Connection ) que recibe una
    // conexion JDBC y hace que los datos del objeto se guarden en BBDD
	public int save(Connection conn) {
		String query = "INSERT INTO APACHE_LOG_TBL (IP, TIMESTAMP, REQUEST, "
				+ "RESULT, BYTES, UA) VALUES ("+ip+","+fecha+","+direccion+","
				+Integer.parseInt(numError)+","+idError+","+navegador+")";
		try {
			conn.setReadOnly(false);
			Statement st = conn.createStatement();
			int filasInsertadas=st.executeUpdate(query);
			st.executeUpdate(query);
			conn.commit();
			return filasInsertadas;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
