package com.cybercom.gustafbratt.kalender;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class KalenderControllerAdvice extends ResponseEntityExceptionHandler {
    //@ControllerAdvice(assignableTypes = CourseController.class)
    //public class CourseControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public void handleCourseNotFoundException(Exception ec) {
        return;
    }

}
