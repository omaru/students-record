package com.joedago.studentsrecord.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class QueryUriTest {
        @Test
        void itShouldBuildQuery(){
            QueryUri queryUri = QueryUri.builder().firstAddress("firstAddress").build();
            then(queryUri.getFirstAddress()).isEqualTo("firstAddress");
        }

}
