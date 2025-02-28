package com.hospital.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital.dao.DiagnosisRepository;
import com.hospital.hospital.response.Response;

import entity.Diagnosis;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {
	@Autowired
	private DiagnosisRepository diagnosisRepository;

	/*
	 * ________________________GET ALL DIAGNOSIS________________________
	 */
	@GetMapping
	public ResponseEntity<Response<Diagnosis>> getAll() {
		List<Diagnosis> diagnosis = (List<Diagnosis>) diagnosisRepository.findAll();

		/*
		 * ··········· 204 NO CONTENT ········
		 */
		if (diagnosis.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		/*
		 * ·········· 200 OK ·········
		 */
		return ResponseEntity.ok(new Response<Diagnosis>("success", diagnosis.size(), diagnosis));
	}
}
