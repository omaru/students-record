package com.joedago.studentsrecord.persistence.repositories;

import static org.assertj.core.api.BDDAssertions.then;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.joedago.studentsrecord.PositionStackProperties;
import com.joedago.studentsrecord.initializer.WireMockInitializer;
import com.joedago.studentsrecord.models.DataResponse;
import com.joedago.studentsrecord.models.PositionResponse;
import com.joedago.studentsrecord.persistence.entities.Student;
import com.joedago.studentsrecord.services.impl.PositionRepositoryImpl;
import com.joedago.studentsrecord.util.ModelsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(initializers = {WireMockInitializer.class})
public class PositionRepositoryTest {
	private PositionRepositoryImpl repository;

	private RestTemplate restTemplate;

	private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
			.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
			.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

	@Autowired
	private WireMockServer wireMockServer;

	@BeforeEach
	public void setUp() {
		restTemplate = new RestTemplate();
		final PositionStackProperties properties = PositionStackProperties.builder().url("http://localhost")
				.token("123pum").forward("forward").build();
		repository = new PositionRepositoryImpl(restTemplate, properties);
	}

	@Test
	void itShouldGetPositionFromStudent() {
		// given
		final Student given = ModelsGenerator.generateValidStudent();
		// when
		final PositionResponse response = repository.getPositionFromStudent(given);
		// then
		then(response).isEqualToComparingFieldByField(PositionResponse.builder()
				.data(DataResponse.builder().latitude(38.897675).longitude(-77.036547).build()).build());
	}
}
