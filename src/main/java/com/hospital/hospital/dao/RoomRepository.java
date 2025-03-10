package com.hospital.hospital.dao;

import org.springframework.data.repository.CrudRepository;

import entity.Nurse;
import entity.Room;

public interface RoomRepository extends CrudRepository<Room, Integer>{
	
}
