package edu.ufrn.pds.healthsystem.config.exception;

import edu.ufrn.pds.healthsystem.config.exception.dto.ApiError;
import edu.ufrn.pds.healthsystem.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

  /**
   * Handle all exceptions created by us in the API
   *
   * @param exception - Exception to be handled
   * @return Human friendly response
   */
  @ExceptionHandler(ApiException.class)
  public ResponseEntity<ApiError> handleApiException(ApiException exception) {
    ApiError errorDto = new ApiError(exception);
    return ResponseEntity.status(errorDto.getStatusCode()).body(errorDto);
  }
}
