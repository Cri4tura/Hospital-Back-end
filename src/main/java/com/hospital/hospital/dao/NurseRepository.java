package com.hospital.hospital.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import entity.Nurse;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface NurseRepository extends CrudRepository<Nurse, Integer> {
	 Optional<Nurse> findByName(String name);  
}
