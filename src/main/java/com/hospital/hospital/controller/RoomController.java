package com.hospital.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital.dao.NurseRepository;
import com.hospital.hospital.dao.RoomRepository;

import entity.Nurse;
import entity.NurseResponse;
import entity.Room;
import entity.RoomResponse;

@RestController
@RequestMapping("/hospital/rooms")
public class RoomController {
	@Autowired
	private RoomRepository roomRepository;

	@GetMapping
    public ResponseEntity<RoomResponse> getAll() {
        List<Room> rooms = (List<Room>) roomRepository.findAll();
 
        if (rooms.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
 
     // Retorna un objeto JSON con los datos
        return ResponseEntity.ok(new RoomResponse("success", rooms.size(), rooms));
    }
}
