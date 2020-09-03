package com.joedago.studentsrecord.services.impl;

import com.joedago.studentsrecord.PositionStackProperties;
import com.joedago.studentsrecord.exceptions.ExceptionMessages;
import com.joedago.studentsrecord.models.PositionResponse;
import com.joedago.studentsrecord.persistence.entities.Student;
import com.joedago.studentsrecord.services.PositionRepository;
import com.joedago.studentsrecord.util.QueryUri;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static com.joedago.studentsrecord.util.PositionConstants.ACCESS_KEY;
import static com.joedago.studentsrecord.util.PositionConstants.QUERY;

@Service
@RequiredArgsConstructor
@Slf4j
public class PositionRepositoryImpl implements PositionRepository {

    @Autowired
    private final RestTemplate restTemplate;

    @Autowired
    private final PositionStackProperties properties;

    @Override
    public PositionResponse getPositionFromStudent(final Student student) {
        final URI uri = getRequestUrl(student);
        try {
            return restTemplate.getForObject(uri, PositionResponse.class);
        } catch (HttpStatusCodeException ex) {
            log.error(ex.getResponseBodyAsString(), ex);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ExceptionMessages.POSITION_ERROR);
        } catch (HttpMessageNotReadableException ex) {
            log.error(ex.getHttpInputMessage().toString(), ex);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ExceptionMessages.POSITION_ERROR);
        }
    }

    private URI getRequestUrl(final Student student) {
        final QueryUri queryUri = QueryUri.firstAddress(student.getStreetAddress1()).secondAddress(student.getStreetAddress2()).build();
        final String address = queryUri.toString();
        return UriComponentsBuilder.fromHttpUrl(properties.getUrl())
                .path(properties.getForward())
                .queryParam(ACCESS_KEY, properties.getToken())
                .queryParam(QUERY, address).build().toUri();
    }

}
