package com.hospital.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital.dao.DietRepository;
import com.hospital.hospital.response.Response;

import entity.Diet;

@RestController
@RequestMapping("/diet")
public class DietController {
	@Autowired
	private DietRepository dietRepository;

	/*
	 * ________________________GET ALL DIETS________________________
	 */
	@GetMapping
	public ResponseEntity<Response<Diet>> getAll() {
		List<Diet> diets = (List<Diet>) dietRepository.findAll();

		/*
		 * ··········· 204 NO CONTENT ········
		 */
		if (diets.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		/*
		 * ·········· 200 OK ·········
		 */
		return ResponseEntity.ok(new Response<Diet>("success", diets.size(), diets));
	}
}
