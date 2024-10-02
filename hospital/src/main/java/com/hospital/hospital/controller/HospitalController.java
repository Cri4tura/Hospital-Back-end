package com.hospital.hospital.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital.model.Enfermero;





@RestController
public class HospitalController {
	
	private ArrayList<Enfermero> listaEnfermeros;

    public HospitalController() {
        listaEnfermeros = new ArrayList<>();
        listaEnfermeros.add(new Enfermero("Juan Pérez", "abc123"));
        listaEnfermeros.add(new Enfermero("María López", "password456"));
        listaEnfermeros.add(new Enfermero("Carlos Sánchez", "secure789"));
        listaEnfermeros.add(new Enfermero("Laura García", "pass123"));
        listaEnfermeros.add(new Enfermero("José Fernández", "qwerty987"));
        listaEnfermeros.add(new Enfermero("Ana Rodríguez", "123secure"));
        listaEnfermeros.add(new Enfermero("Luis Martínez", "nursepass"));
        listaEnfermeros.add(new Enfermero("Sofía Gómez", "clave321"));
        listaEnfermeros.add(new Enfermero("Pedro Ruiz", "mypassword"));
        listaEnfermeros.add(new Enfermero("Elena Ramírez", "pass456"));
    }

	@GetMapping("/enfermeros") 
	public ArrayList<Enfermero> obtenerEnfermeros() {

        return listaEnfermeros;
    }
	
	@PostMapping("/login") 
	public boolean validarLogin(@RequestParam String usuario, @RequestParam String password) {
        boolean logged = false;
        
        for (Enfermero enfermero : listaEnfermeros) {
            if (enfermero.getNombre().equals(usuario) && enfermero.getPassword().equals(password)) {
                logged = true; 
            }
        }

        return logged;
    }
    
	

}
