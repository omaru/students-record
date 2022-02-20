package com.joedago.studentsrecord.util;

import com.joedago.studentsrecord.models.DataResponse;
import com.joedago.studentsrecord.models.PositionResponse;
import com.joedago.studentsrecord.models.StudentSimilarity;
import com.joedago.studentsrecord.persistence.entities.Student;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ModelsGenerator {

	public static final Integer STUDENT_AGE = 25;
	public static final Integer STUDENT_ID_1 = 1;
	public static final Integer STUDENT_ID_2 = 2;

	public static Student generateValidStudent() {
		return generateValidStudent(STUDENT_ID_1);
	}

	public static Student generateValidStudent(final long studentId) {
		final Calendar birthDate = Calendar.getInstance();
		birthDate.add(Calendar.YEAR, -STUDENT_AGE);
		return Student.builder().studentId(studentId).firstName("name").lastName("lastname").email("email")
				.state("state").birthDate(new Date(birthDate.getTimeInMillis())).build();
	}

	public static Student generate75SimilarityStudent() {
		final Student student = generateValidStudent();
		student.setFirstName("othername");
		return student;
	}

	public static Student generate50SimilarityStudent() {
		Student student = generate75SimilarityStudent();
		student.setLastName("othername");
		return student;
	}

	public static Student generate25SimilarityStudent() {
		Student student = generate50SimilarityStudent();
		student.setState("otherstate");
		return student;
	}

	public static Student generate0SimilarityStudent() {
		Student student = generate25SimilarityStudent();
		student.setBirthDate(new Date(Calendar.getInstance().getTimeInMillis()));
		return student;
	}

	public static PositionResponse generatePositionResponse() {
		PositionResponse response = new PositionResponse();
		List<DataResponse> data = new ArrayList<>();
		DataResponse d = new DataResponse();
		d.setLatitude(123D);
		d.setLongitude(456D);
		data.add(d);
		response.setData(data);
		return response;
	}

	public static StudentSimilarity generateStudentSimilarity() {
		Student student1 = generateValidStudent();
		Student student2 = generateValidStudent();
		StudentSimilarity similarity = new StudentSimilarity();
		similarity.setSimilarityPercentage(100);
		similarity.setStudent1(student1);
		similarity.setStudent2(student2);
		return similarity;
	}
}
