package com.ibm.developer.passengerservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/passengers")
public class PassengerController {

	private PassengerRepo repo;
	private PassengerService service;

	

	protected PassengerController(PassengerRepo repo, PassengerService service) {
		this.repo = repo;
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<Iterable<Passenger>> findAll() {
		return ResponseEntity.ok(repo.findAll());
	}

	@PostMapping
	public ResponseEntity<Passenger> addNewPassenger(@RequestBody Passenger passenger) {
		return ResponseEntity.ok(service.savePassenger(passenger));
	}

	@ExceptionHandler(ClientException.class)
	public ResponseEntity<String> handleCLientError(ClientException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}

}
