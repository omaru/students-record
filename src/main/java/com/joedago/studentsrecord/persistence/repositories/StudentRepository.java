package com.joedago.studentsrecord.persistence.repositories;

import com.joedago.studentsrecord.persistence.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByEmail(String email);

	Student findByStudentId(long studentId);
}
