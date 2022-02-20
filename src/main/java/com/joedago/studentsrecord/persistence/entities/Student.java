package com.joedago.studentsrecord.persistence.entities;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student", schema = "students_record")
public class Student {

	@Id
	@Column(name = "studentid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;

	@Email
	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;

	@NotBlank
	@Column(name = "firstname", length = 45, nullable = false, unique = false)
	private String firstName;

	@NotBlank
	@Column(name = "lastname", length = 45, nullable = false, unique = false)
	private String lastName;

	@NotNull
	@Column(name = "birthdate", length = 45, nullable = false, unique = false)
	private Date birthDate;

	@NotBlank
	@Column(name = "streetaddress1", length = 200, nullable = false, unique = false)
	private String streetAddress1;

	@Column(name = "streetaddress2", length = 100, nullable = true, unique = false)
	private String streetAddress2;

	@NotBlank
	@Column(name = "city", length = 100, nullable = false, unique = false)
	private String city;

	@NotBlank
	@Column(name = "state", length = 45, nullable = false, unique = false)
	private String state;

	@NotBlank
	@Column(name = "country", length = 45, nullable = false, unique = false)
	private String country;

	@NotNull
	@Column(name = "zipcode", nullable = false, unique = false)
	private Integer zipCode;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;

	@Column(name = "ageatregistration")
	private Integer ageAtRegistration;
}
