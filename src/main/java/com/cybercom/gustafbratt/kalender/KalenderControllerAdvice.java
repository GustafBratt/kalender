package com.cybercom.gustafbratt.kalender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class KalenderControllerAdvice extends ResponseEntityExceptionHandler {
    Logger logger = LoggerFactory.getLogger(KalenderControllerAdvice.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public void handleCourseNotFoundException(RuntimeException ex) {
        logger.error("Exception: ", ex);
        return;
    }

}
