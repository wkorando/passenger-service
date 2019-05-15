package com.ibm.developer.passengerservice;

import org.springframework.stereotype.Service;

@Service
public class PassengerService {

	private PassengerRepo repo;

	protected PassengerService(PassengerRepo repo) {
		this.repo = repo;
	}

	public Passenger savePassenger(Passenger passenger) {
		if (!passenger.getFirstName().isEmpty() && !passenger.getLastName().isEmpty() && passenger.getRating() > 0) {
			return repo.save(passenger);

		}
		throw new ClientException("Required field missing!");
	}
}
