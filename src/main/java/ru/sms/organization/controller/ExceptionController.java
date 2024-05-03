package ru.sms.organization.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.sms.organization.exception.EntityNotFoundException;
import ru.sms.organization.model.utils.ErrorInfo;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    ErrorInfo handleBadRequest(HttpServletRequest req, RuntimeException ex) {
        if (ex instanceof EntityNotFoundException) //quick-fix: rethrow exception
            throw ex;
        return new ErrorInfo(req.getRequestURI(), ex);
    }

}
