package com.hospital.hospital.dao;

import org.springframework.data.repository.CrudRepository;

import entity.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>  {

}
