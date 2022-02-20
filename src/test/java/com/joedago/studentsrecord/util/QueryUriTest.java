package com.joedago.studentsrecord.util;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Test;

public class QueryUriTest {
	@Test
	void itShouldBuildQuery() {
		QueryUri queryUri = QueryUri.builder().firstAddress("firstAddress").build();
		then(queryUri.getFirstAddress()).isEqualTo("firstAddress");
	}
}
