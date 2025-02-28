package com.hospital.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital.dao.MobilizationRepository;
import com.hospital.hospital.response.Response;

import entity.Mobilization;

@RestController
@RequestMapping("/mobilization")
public class MobilizationController {
	@Autowired
	private MobilizationRepository mobilizationRepository;

	/*
	 * ________________________GET ALL MOBILIZATIONS________________________
	 */
	@GetMapping
	public ResponseEntity<Response<Mobilization>> getAll() {
		List<Mobilization> mobilizations = (List<Mobilization>) mobilizationRepository.findAll();

		/*
		 * ··········· 204 NO CONTENT ········
		 */
		if (mobilizations.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		/*
		 * ·········· 200 OK ·········
		 */
		return ResponseEntity.ok(new Response<Mobilization>("success", mobilizations.size(), mobilizations));
	}
}
