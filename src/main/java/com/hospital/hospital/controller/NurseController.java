package com.hospital.hospital.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/login")
	public @ResponseBody boolean login(@RequestParam String name, @RequestParam String password) {
		Optional<Nurse> nurse = nurseRepository.validateLogin(name, password);
		return nurse.isPresent(); 
	}
	
	@GetMapping("/name/{name}")
	public @ResponseBody Optional<Nurse> findByName(@PathVariable("name") String name){
		return nurseRepository.findByName(name);
	}
}
