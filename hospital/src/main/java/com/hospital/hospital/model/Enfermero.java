package com.hospital.hospital.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Enfermero {
	
	@JsonProperty("nombre")
	private String nombre;
	
	@JsonProperty("password")
	private String password;
	
	public Enfermero(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		

}
