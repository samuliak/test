package com.samuliak.test.common;

import com.samuliak.test.common.exception.ObjectNotFoundException;
import com.samuliak.test.common.response.NotFoundWebResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Log4j2
public class WebExceptionHandlerAdvice {

    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseBody
    public NotFoundWebResponse handleException(HttpServletRequest request, ObjectNotFoundException ex) {
        log.error("WebExceptionHandlerAdvice, ObjectNotFoundException: URL={}", request.getRequestURL());
        log.error(ex.getMessage(), ex);

        return new NotFoundWebResponse(ex.getMessage());
    }

}
