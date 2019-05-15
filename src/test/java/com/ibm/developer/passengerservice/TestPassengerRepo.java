package com.ibm.developer.passengerservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig
@ContextConfiguration(classes = { PassengerServiceApplication.class }, initializers = TestPassengerRepo.Initializer.class)
public class TestPassengerRepo {

	public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		@Override
		public void initialize(ConfigurableApplicationContext applicationContext) {
			TestPropertyValues.of("spring.datasource.url=jdbc:tc:postgresql:11.2://localhost/test", //
					// JDBC url must start with "jdbc:tc" followed by type of database you are
					// connecting to
					"spring.datasource.username=test", //
					"spring.datasource.password=test", //
					"spring.jpa.hibernate.ddl-auto=create-drop", //
					// username/password can be arbitrary strings
					"spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver")//
					// Must use the ContainerDatabaseDriver which starts up the Docker container, is
					// eventually replaced with database appropriate driver
					.applyTo(applicationContext);
		}
	}
	
	@Autowired
	private PassengerRepo repo;

	@Test
//	@Order(1)
	public void testReadFromStormsTable() {
		repo.save(new Passenger("Thor", "Odinson", 4.95));
		repo.save(new Passenger("Steve", "Rodgers", 5.00));
		repo.save(new Passenger("Tony", "Stark", 5.00));
		assertThat(repo.count()).isEqualTo(3);

	}
}
