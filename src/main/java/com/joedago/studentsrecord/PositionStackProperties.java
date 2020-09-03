package com.joedago.studentsrecord;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "positionstack")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionStackProperties {

	private String url;
	private String token;
	private String forward;
	
}
