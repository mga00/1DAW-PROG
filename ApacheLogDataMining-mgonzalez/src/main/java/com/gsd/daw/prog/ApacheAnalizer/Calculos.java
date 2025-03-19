package com.gsd.daw.prog.ApacheAnalizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculos {
	
	public Map<String, Integer> cuantasIps (List<LineaLogA> lista){
		Map<String, Integer> mapIps = new HashMap<>();
		for (LineaLogA l : lista) {
			String ip= l.getIp();
			mapIps.put(ip, mapIps.getOrDefault(ip, 0) + 1);
		}
		Map<String, Integer> ipMas10 = new HashMap<>();
		for (Map.Entry<String, Integer> entry : mapIps.entrySet()) {
			if (entry.getValue()>10) {
				ipMas10.put(entry.getKey(), entry.getValue());
			}
		}
		return ipMas10;
	}
	public void mostrarIps(Map<String, Integer> mapaIps) {
		if(mapaIps.isEmpty()) {
			System.out.println("No hay ninguna ip que se repita más de 10 veces");
			return;
		}
		System.out.println("Listado de las IPs que aparecen 10 o más veces:");
		for (Map.Entry<String, Integer> entry : mapaIps.entrySet()) {
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
	}
	public Map<String, Integer> contadorStatusCode (List<LineaLogA> lista){
		Map<String, Integer> mapStatusCode = new HashMap<>();
		for (LineaLogA l : lista) {
			String StatusCode= l.getNumError();
			mapStatusCode.put(StatusCode, mapStatusCode.getOrDefault(StatusCode, 0) + 1);
		}
		return mapStatusCode;
	}
	public void MostrarListaStCode(Map<String, Integer> mapStatusCode) {
		System.out.println("Listado de numero de veces que aparece cada Status Code:");
		for (Map.Entry<String, Integer> entry : mapStatusCode.entrySet()) {
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
	}
}
