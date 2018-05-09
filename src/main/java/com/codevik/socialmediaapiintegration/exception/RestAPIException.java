package com.codevik.socialmediaapiintegration.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class RestAPIException extends RuntimeException {

  private final HttpStatus errorCode;

  public RestAPIException(HttpStatus errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }
}
