package com.hospital.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital.dao.PatientRepository;
import com.hospital.hospital.response.Response;

import entity.Patient;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;

	/*
	 * ________________________GET ALL PATIENTS________________________
	 */
	@GetMapping
	public ResponseEntity<Response<Patient>> getAll() {
		List<Patient> patients = (List<Patient>) patientRepository.findAll();

		/*
		 * ··········· 204 NO CONTENT ········
		 */
		if (patients.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		/*
		 * ·········· 200 OK ·········
		 */
		return ResponseEntity.ok(new Response<Patient>("success", patients.size(), patients));
	}
}
