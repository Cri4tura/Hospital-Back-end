package com.hospital.hospital.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital.dao.NurseRepository;
import com.hospital.hospital.response.Response;

import entity.Nurse;

@RestController
@RequestMapping("/nurse")
public class NurseController {

	@Autowired
	private NurseRepository nurseRepository;

	@GetMapping("/ping")
    public ResponseEntity<String> ping() {
        String message = "Pong! Server is up and running. Current time: " + new Date();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
	
	/*
	 * ________________________GET ALL NURSES________________________
	 */
	@GetMapping
	public ResponseEntity<Response<Nurse>> getAll() {
		List<Nurse> nurses = (List<Nurse>) nurseRepository.findAll();

		/*
		 * ··········· 204 NO CONTENT ········
		 */
		if (nurses.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		/*
		 * ·········· 200 OK ·········
		 */
		return ResponseEntity.ok(new Response<Nurse>("success", nurses.size(), nurses));
	}

	/*
	 * ________________________FIND BY ID________________________
	 */
	@GetMapping("id/{id}")
	public ResponseEntity<Nurse> findById(@PathVariable("id") int id) {
		Optional<Nurse> nurse = nurseRepository.findById(id);

		/*
		 * ·········· 200 OK···········
		 */
		if (nurse.isPresent()) {
			return ResponseEntity.ok(nurse.get());
		} else {
			/*
			 * ·········· 404 NOT FOUND ········
			 */
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	/*
	 * ________________________FIND BY NAME________________________
	 */
	@GetMapping("name/{name}")
	public ResponseEntity<Optional<Nurse>> findByName(@PathVariable("name") String name) {
		Optional<Nurse> nurse = nurseRepository.findByName(name);

		/*
		 * ········ 200 OK ·······
		 */
		if (nurse.isPresent()) {
			return ResponseEntity.ok(nurse);
		} else {
			/*
			 * ········ 404 NOT FOUND ······
			 */
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	/*
	 * ________________________LOGIN________________________
	 */
	@PostMapping("/login")
	public ResponseEntity<Optional<Nurse>> login(@RequestParam String email, @RequestParam String password) {
		Optional<Nurse> nurse = nurseRepository.findByEmail(email);

		/*
		 * ······· 404 NOT FOUND ······
		 */
		if (!nurse.isPresent())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		/*
		 * ········ 401 UNAUTHORIZED ····
		 */
		if (!nurse.get().getPassword().equals(password))
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

		/*
		 * ········ 200 OK ·········
		 */
		return ResponseEntity.ok(nurse);
	}

	/*
	 * ________________________SIGNIN________________________
	 */
	@PostMapping("/signin")
	public @ResponseBody ResponseEntity<?> register(@RequestBody Nurse nurse) {
		try {

			/*
			 * ·········· 400 BAD REQUEST ······
			 */
			if (nurse.getName().isBlank())
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty name");
			if (nurse.getSurname().isBlank())
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty surname");
			if (nurse.getEmail() .isBlank())
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty email");
			if (nurse.getPassword().isBlank())
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty password");
			if (nurse.getBirthDate() == null)
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty birthDate");

			/*
			 * ·········· 409 CONFLICT ········
			 */
			if (nurseRepository.existsByEmail(nurse.getEmail()))
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");

			Nurse n = new Nurse();
			n.setName(nurse.getName());
			n.setSurname(nurse.getSurname());
			n.setEmail(nurse.getEmail());
			n.setPassword(nurse.getPassword());
			n.setBirthDate(nurse.getBirthDate());
			nurse.setRegisterDate(new Date());
			nurseRepository.save(n);

			/*
			 * ·········· 201 CREATED ········
			 */
			return ResponseEntity.status(HttpStatus.CREATED).body(n);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	/*
	 * ________________________UPDATE NURSE________________________
	 */
	@PutMapping("/{id}")
	public ResponseEntity<?> updateNurse(@PathVariable("id") int id, @RequestBody Nurse updatedNurse) {

		/*
		 * ·········· 400 BAD_REQUEST ·······
		 */
		if (updatedNurse.getName().isBlank())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty name");
		if (updatedNurse.getSurname().isBlank())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty surname");
		if (updatedNurse.getEmail() .isBlank())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty email");
		if (updatedNurse.getPassword().isBlank())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty password");
		if (updatedNurse.getBirthDate() == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty birthDate");

		/*
		 * ·········· 404 NOT_FOUND ·······
		 */
		Optional<Nurse> existingNurseOpt = nurseRepository.findById(id);
		if (!existingNurseOpt.isPresent())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nurse not found");

		Nurse existingNurse = existingNurseOpt.get();
		existingNurse.setName(updatedNurse.getName());
		existingNurse.setSurname(updatedNurse.getSurname());
		existingNurse.setEmail(updatedNurse.getEmail());
		existingNurse.setPassword(updatedNurse.getPassword());
		existingNurse.setBirthDate(updatedNurse.getBirthDate());
		existingNurse.setRegisterDate(updatedNurse.getRegisterDate());
		nurseRepository.save(existingNurse);

		/*
		 * ·········· 200 OK ·······
		 */
		return ResponseEntity.ok(existingNurse);
	}


	/*
	 * ________________________UPDATE NURSE________________________
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteById(@PathVariable("id") int id) {
		
		/*
		 * ·········· 200 OK ·······
		 */
		if (nurseRepository.existsById(id)) {
			nurseRepository.deleteById(id);
			return ResponseEntity.ok(true);
		} else
			/*
			 * ·········· 404 NOT_FOUND ·······
			 */
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);

	}

}
