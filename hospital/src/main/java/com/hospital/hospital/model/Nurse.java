package com.hospital.hospital.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nurse {
	
	@JsonProperty("nombre")
	private String name;
	
	@JsonProperty("password")
	private String password;
	
	public Nurse(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String nombre) {
		this.name = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		

}
