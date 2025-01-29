package com.hospital.hospital.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import entity.Nurse;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface NurseRepository extends CrudRepository<Nurse, Integer> {
	 Optional<Nurse> findByName(String name);
	 
	 boolean existsByEmail(String email);
	 
	 @Query("SELECT n FROM Nurse n WHERE n.name = :name AND n.password = :password")
	    Optional<Nurse> validateLogin(@Param("name") String name, @Param("password") String password);
	 
	 Optional<Nurse> findById(int id);
}

