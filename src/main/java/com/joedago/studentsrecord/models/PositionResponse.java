package com.joedago.studentsrecord.models;

import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PositionResponse {

	@Singular("data")
	private List<DataResponse> data;
}
