package com.joedago.studentsrecord.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joedago.studentsrecord.persistence.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>  {

	 Student findByEmail(String email);
	 Student findByStudentId(long studentId);

}
