package com.hospital.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital.dao.RoomRepository;
import com.hospital.hospital.response.Response;

import entity.Room;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomRepository roomRepository;

	/*
	 * ________________________GET ALL ROOMS________________________
	 */
	@GetMapping
	public ResponseEntity<Response<Room>> getAll() {
		List<Room> rooms = (List<Room>) roomRepository.findAll();

		/*
		 * ··········· 204 NO CONTENT ········
		 */
		if (rooms.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		/*
		 * ·········· 200 OK ·········
		 */
		return ResponseEntity.ok(new Response<Room>("success", rooms.size(), rooms));
	}
}
