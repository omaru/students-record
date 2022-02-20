package com.joedago.studentsrecord.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse {
	private Double latitude;
	private Double longitude;
	private String type;
	private String name;
	private Integer number;
	private Integer postalCode;
	private String street;
	private Integer confidence;
	private String region;
	private String regionCode;
	private String county;
	private String locality;
	private String administrativeArea;
	private String neighbourhood;
	private String country;
	private String countryCode;
	private String continent;
	private String label;
}
