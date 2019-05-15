package com.ibm.developer.passengerservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/passengers")
public class PassengerController {

	
	@GetMapping
	public ResponseEntity<String> findAll(){
		return ResponseEntity.ok("Hello world!");
	}
}
