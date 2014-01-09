package com.example.examenenero;

public class Destino {
	
	private String zona;
	private String continente;
	private String precio;
	
	public Destino(String zo, String co, String pre){
		zona = zo;
		continente = co;
		precio = pre;
	}
	
	public String getZona(){
		return zona;
	}

	public String getContinente(){
		return continente;
	}
	
	public String getPrecio(){
		return precio;
	}
}
