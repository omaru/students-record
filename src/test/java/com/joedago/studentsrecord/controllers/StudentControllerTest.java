package com.joedago.studentsrecord.controllers;

import com.joedago.studentsrecord.persistence.entities.Student;
import com.joedago.studentsrecord.services.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.joedago.studentsrecord.util.ModelsGenerator.generateValidStudent;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentController = new StudentController(studentService);
    }

    @Test
    void itShouldSaveStudentWhenCreatingAnewStudent() {
        // Given
        final long studentId = 1L;
        final Student given = generateValidStudent(studentId);
        // when
        studentController.saveStudent(given);
        //then
        verify(studentService).saveStudent(given);
    }
}
