package com.joedago.studentsrecord.models;

import lombok.*;

import javax.validation.Valid;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PositionResponse {

	@Singular("data")
	private List<DataResponse> data;

}
