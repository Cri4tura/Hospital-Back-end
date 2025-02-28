package com.hospital.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital.dao.DrainageRepository;
import com.hospital.hospital.response.Response;

import entity.Drainage;

@RestController
@RequestMapping("/drainage")
public class DrainageController {
	@Autowired
	private DrainageRepository drainageRepository;

	/*
	 * ________________________GET ALL DRAINAGES________________________
	 */
	@GetMapping
	public ResponseEntity<Response<Drainage>> getAll() {
		List<Drainage> drainages = (List<Drainage>) drainageRepository.findAll();

		/*
		 * ··········· 204 NO CONTENT ········
		 */
		if (drainages.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		/*
		 * ·········· 200 OK ·········
		 */
		return ResponseEntity.ok(new Response<Drainage>("success", drainages.size(), drainages));
	}
}
