package com.hospital.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.hospital.hospital.dao.NurseRepository;
import entity.Nurse;


@RestController
@RequestMapping("/nurse")
public class NurseController {
	@Autowired 
	
	private NurseRepository nurseRepository;

	@GetMapping("/index") 
	public @ResponseBody Iterable<Nurse> getAll() {
		return nurseRepository.findAll();
    }
	
	
	/*
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
	*/

}
