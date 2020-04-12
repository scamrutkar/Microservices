package com.javacase.sagar.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.net.URI;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuccessResponse {

    private String message;
    private URI uri;
    private Object object;
    private Timestamp timestamp;

}
