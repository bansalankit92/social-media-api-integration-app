package com.codevik.socialmediaapiintegration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"error_type", "error_message"})
public class RestErrorResponse {

    @JsonProperty("error_type")
    private HttpStatus type;

    @JsonProperty("error_message")
    private String message;

}
