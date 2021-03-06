package com.finance.backend.handlers;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import com.finance.backend.models.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler implements ErrorController {
  private static final Logger log = LoggerFactory.getLogger(GlobalErrorHandler.class);

  private ResponseEntity<ResponseDto> createHttpResponse(HttpStatus httpStatus, String message) {
    ResponseDto httpResponse =
        new ResponseDto(httpStatus.value(), httpStatus.getReasonPhrase(), message);
    return new ResponseEntity<>(httpResponse, httpStatus);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseDto> genericException(Exception exception) {
    log.info(exception.getMessage());
    return this.createHttpResponse(INTERNAL_SERVER_ERROR, exception.getMessage());
  }
}
