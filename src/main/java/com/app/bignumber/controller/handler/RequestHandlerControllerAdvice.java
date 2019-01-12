package com.app.bignumber.controller.handler;

import com.app.bignumber.controller.BigNumberController;
import com.app.bignumber.exception.InvalidRangeException;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@ControllerAdvice(assignableTypes = BigNumberController.class)
@Log
public class RequestHandlerControllerAdvice {

    @ExceptionHandler({NumberFormatException.class, InvalidRangeException.class})
    @ResponseStatus(BAD_REQUEST)
    public void handleInValidRequestException(final HttpServletRequest request) {
        log.severe("Request URI is  " + request.getRequestURI());
    }

}
