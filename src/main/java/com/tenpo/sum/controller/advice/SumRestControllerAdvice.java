package com.tenpo.sum.controller.advice;

import com.tenpo.sum.constant.ProblemType;
import com.tenpo.sum.dto.Problem;
import com.tenpo.sum.exception.ResourceNotFoundException;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestControllerAdvice
public class SumRestControllerAdvice {

    Logger logger = LoggerFactory.getLogger(SumRestControllerAdvice.class);

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Problem handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest request) {
        logger.error(ex.getMessage());
        ProblemType problemType = ProblemType.HTTP_MESSAGE_NOT_READABLE;

        return new Problem(
                problemType.type,
                problemType.title,
                problemType.code,
                problemType.status,
                ex.getMessage(),
                URI.create(request.getRequestURI())
        );
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Problem handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex, HttpServletRequest request) {
        logger.error(ex.getMessage());
        ProblemType problemType = ProblemType.HTTP_MEDIA_TYPE_NOT_SUPPORTED;

        return new Problem(
                problemType.type,
                problemType.title,
                problemType.code,
                problemType.status,
                ex.getMessage(),
                URI.create(request.getRequestURI())
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Problem handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        logger.error(ex.getMessage());
        ProblemType problemType = ProblemType.RESOURCE_NOT_FOUND;

        return new Problem(
                problemType.type,
                problemType.title,
                problemType.code,
                problemType.status,
                ex.getMessage(),
                URI.create(request.getRequestURI())
        );
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Problem handleNoHandlerFoundException(NoHandlerFoundException ex, HttpServletRequest request) {
        logger.error(ex.getMessage());
        ProblemType problemType = ProblemType.HTTP_METHOD_NO_FOUND;

        return new Problem(
                problemType.type,
                problemType.title,
                problemType.code,
                problemType.status,
                ex.getMessage(),
                URI.create(request.getRequestURI())
        );
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    public Problem handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        logger.error(ex.getMessage());
        ProblemType problemType = ProblemType.HTTP_REQUEST_METHOD_NOT_SUPPORTED;

        return new Problem(
                problemType.type,
                problemType.title,
                problemType.code,
                problemType.status,
                ex.getMessage(),
                URI.create(request.getRequestURI())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Problem handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        logger.error(ex.getMessage());
        ProblemType problemType = ProblemType.HTTP_BAD_REQUEST;

        return new Problem(
                problemType.type,
                problemType.title,
                problemType.code,
                problemType.status,
                ex.getMessage(),
                URI.create(request.getRequestURI())
        );
    }

    @ExceptionHandler(RequestNotPermitted.class)
    @ResponseStatus(value = HttpStatus.TOO_MANY_REQUESTS)
    public Problem handleRequestNotPermittedException(RequestNotPermitted ex, HttpServletRequest request) {
        logger.error(ex.getMessage());
        ProblemType problemType = ProblemType.TOO_MANY_REQUESTS;

        return new Problem(
                problemType.type,
                problemType.title,
                problemType.code,
                problemType.status,
                ex.getMessage(),
                URI.create(request.getRequestURI())
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Problem handleUncaughtException(Exception ex, HttpServletRequest request) {
        logger.error(ex.getMessage(), ex);
        ProblemType problemType = ProblemType.INTERNAL_SERVER_ERROR;

        return new Problem(
                problemType.type,
                problemType.title,
                problemType.code,
                problemType.status,
                "Internal server error",
                URI.create(request.getRequestURI())
        );
    }
}
