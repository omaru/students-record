package com.joedago.studentsrecord.service;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.joedago.studentsrecord.Application;
import com.joedago.studentsrecord.models.PositionResponse;
import com.joedago.studentsrecord.persistence.entities.Student;
import com.joedago.studentsrecord.services.PositionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest(classes = Application.class)
class PositionRepositoryIT {

	@Autowired
	private PositionRepository positionRepository;

	@Test
	void testGetPositionFromStudent() {
		Student student = new Student();
		student.setStreetAddress1("1600 Pennsylvania Ave NW");
		student.setCity("Washington");
		student.setState("DC");
		PositionResponse response = positionRepository.getPositionFromStudent(student);
		assertNotNull(response);
		assertNotNull(response.getData());
		assertFalse(response.getData().isEmpty());
	}

	@Test
	void testGetPositionWithNoAddress() {
		Student student = new Student();
		try {
			positionRepository.getPositionFromStudent(student);
			fail("should throw an exception");
		} catch (ResponseStatusException ex) {
			assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, ex.getStatus());
		}
	}
}
