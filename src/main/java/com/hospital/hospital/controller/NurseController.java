package com.hospital.hospital.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital.dao.NurseRepository;
import entity.Nurse;

@RestController
@RequestMapping("/nurse")
public class NurseController {

	@Autowired
	private NurseRepository nurseRepository;

	@GetMapping("/index")
	public ResponseEntity<Iterable<Nurse>> getAll() {
	    Iterable<Nurse> nurses = nurseRepository.findAll();

	    if (!nurses.iterator().hasNext())
	        // 204 No Content si no hay registros
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	    // 200 OK si se encuentran registros
	    return ResponseEntity.ok(nurses);
	}


	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String name, @RequestParam String password) {
	    // Verificar si el usuario existe
	    Optional<Nurse> nurse = nurseRepository.findByName(name);
	    
	    if (!nurse.isPresent()) 
	        // 404 Not Found si el nombre de usuario no existe en la base de datos
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nurse not found");

	    // Verificar si la contraseña coincide
	    if (!nurse.get().getPassword().equals(password)) 
	        // 401 Unauthorized si el nombre existe pero la contraseña es incorrecta
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");

	    // 200 OK si el login es exitoso
	    return ResponseEntity.ok("Login successful");
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Optional<Nurse>> findByName(@PathVariable("name") String name) {
	    Optional<Nurse> nurse = nurseRepository.findByName(name);
	    
	    if (nurse.isPresent()) {
	    	// 200 OK si encuentra el nombre
	        return ResponseEntity.ok(nurse);
	    } else {
	    	// 404 NOT FOUND si no ecuentra el nombre
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}


	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestParam String name, @RequestParam String password) {
		try {
			// Validación de campos
			if (name == null || name.isEmpty() || password == null || password.isEmpty())
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name and password cannot be empty");

			// Comprobar si el nombre de usuario ya existe
			if (nurseRepository.existsByName(name))
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Nurse with this name already exists");

			// Crear y guardar la entidad
			Nurse n = new Nurse();
			n.setName(name);
			n.setPassword(password);
			nurseRepository.save(n);

			return ResponseEntity.ok("Saved");

		} catch (Exception e) {
			// Error interno del servidor
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An error occurred while saving the nurse");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Nurse> findById(@PathVariable("id") int id) {
	    Optional<Nurse> nurse = nurseRepository.findById(id);

	    if (nurse.isPresent()) {
	    	// 200 OK si se encuentra la enfermera
	        return ResponseEntity.ok(nurse.get());  
	    } else {
	    	// 404 Not Found si no se encuentra la enfermera
	        return ResponseEntity.notFound().build(); 
	    }
	}

}
