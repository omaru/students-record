package com.joedago.studentsrecord.util;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QueryUri {
    @NotBlank
    private String firstAddress;
    @NotBlank
    private String secondAddress;
    @Override
    public void toString(){

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
