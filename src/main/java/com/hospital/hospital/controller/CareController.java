package com.hospital.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital.dao.CareRepository;
import com.hospital.hospital.response.Response;

import entity.Care;

@RestController
@RequestMapping("/care")
public class CareController {
	@Autowired
	private CareRepository careRepository;

	/*
	 * ________________________GET ALL CARES________________________
	 */
	@GetMapping
	public ResponseEntity<Response<Care>> getAll() {
		List<Care> cares = (List<Care>) careRepository.findAll();

		/*
		 * ··········· 204 NO CONTENT ········
		 */
		if (cares.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		/*
		 * ·········· 200 OK ·········
		 */
		return ResponseEntity.ok(new Response<Care>("success", cares.size(), cares));
	}
}
