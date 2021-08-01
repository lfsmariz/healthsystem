package edu.ufrn.pds.healthsystem.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/** All application exceptions must extends this class, so we can handle all in the same place */
@Getter
public class ApiException extends RuntimeException {

  private static final long serialVersionUID = 42L;

  private HttpStatus statusCode;
  private String code;
  private String message;

  public ApiException(HttpStatus statusCode, String code, String message) {
    super(code);
    this.statusCode = statusCode;
    this.code = code;
    this.message = message;
  }

  public ApiException(HttpStatus statusCode, String code, String message, Throwable cause) {
    super(code, cause);
    this.statusCode = statusCode;
    this.code = code;
    this.message = message;
  }
}