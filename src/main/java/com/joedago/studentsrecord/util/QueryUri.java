package com.joedago.studentsrecord.util;

import com.joedago.studentsrecord.persistence.entities.Student;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QueryUri {
	@NotBlank
	private String firstAddress;
	@NotBlank
	private String secondAddress;
	private Student student;

	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();
		if (student.getStreetAddress1() != null) {
			builder.append(student.getStreetAddress1());
		}
		if (student.getStreetAddress2() != null) {
			builder.append(" ");
			builder.append(student.getStreetAddress2());
		}
		builder.append(", ");
		if (student.getCity() != null) {
			builder.append(student.getCity());
			builder.append(" ");
		}
		if (student.getState() != null) {
			builder.append(student.getState());
			builder.append(" ");
		}
		if (student.getZipCode() != null) {
			builder.append(student.getZipCode());
			builder.append(" ");
		}
		if (student.getCountry() != null) {
			builder.append(student.getCountry());
		}
		return builder.toString();
	}
}
