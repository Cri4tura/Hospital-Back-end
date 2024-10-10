package com.hospital.hospital.controller;

import java.util.ArrayList;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital.model.Nurse;





@RestController
@RequestMapping("/nurse")
public class HospitalController {
	
	private ArrayList<Nurse> nurseList;

    public HospitalController() {
        nurseList = new ArrayList<>();
        nurseList.add(new Nurse("Juan Pérez", "abc123"));
        nurseList.add(new Nurse("María López", "password456"));
        nurseList.add(new Nurse("Carlos Sánchez", "secure789"));
        nurseList.add(new Nurse("Laura García", "pass123"));
        nurseList.add(new Nurse("José Fernández", "qwerty987"));
        nurseList.add(new Nurse("Ana Rodríguez", "123secure"));
        nurseList.add(new Nurse("Luis Martínez", "nursepass"));
        nurseList.add(new Nurse("Sofía Gómez", "clave321"));
        nurseList.add(new Nurse("Pedro Ruiz", "mypassword"));
        nurseList.add(new Nurse("Elena Ramírez", "pass456"));
    }

	@GetMapping("/index") 
	public ArrayList<Nurse> getAll() {

        return nurseList;
    }
	
	@PostMapping("/login") 
	public @ResponseBody ResponseEntity<Boolean> login(@RequestParam String user, @RequestParam String password) {
        
        for (Nurse nurse : nurseList) {
            if (nurse.getName().equals(user) && nurse.getPassword().equals(password)) {
            	return ResponseEntity.ok(true);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
    }
    
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Nurse> findName(@PathVariable String name){
		for (Nurse nurse : nurseList) {
			if (name.equals(nurse.getName())) {
				return ResponseEntity.ok(nurse);
			}
		}
		return ResponseEntity.notFound().build();
	}
	

}
