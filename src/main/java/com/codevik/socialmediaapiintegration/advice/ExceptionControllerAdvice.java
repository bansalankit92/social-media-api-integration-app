package com.codevik.socialmediaapiintegration.advice;


import com.codevik.socialmediaapiintegration.exception.InvalidHeaderException;
import com.codevik.socialmediaapiintegration.exception.RestAPIException;
import com.codevik.socialmediaapiintegration.log.annotation.Trace;
import com.codevik.socialmediaapiintegration.log.eventtype.LogEventType;
import com.codevik.socialmediaapiintegration.model.RestErrorResponse;

import com.codevik.socialmediaapiintegration.util.appconstants.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

    /*
     * catching all unhandled exceptions from Controllers
     */
    @ExceptionHandler(Exception.class)
    @Trace(type = LogEventType.EXCEPTION)
    public ResponseEntity<RestErrorResponse> processException(Exception ex) {
        log.error("Exception caught: ", ex);
        ResponseEntity responseEntity = new ResponseEntity<>(
                new RestErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                        ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

        return responseEntity;
    }

//    /**
//     * method to handle HttpMessageNotReadableException
//     */
//    @ExceptionHandler(value = {HttpMessageNotReadableException.class,
//            MissingServletRequestParameterException.class})
//    @Trace(type = LogEventType.EXCEPTION)
//    private ResponseEntity<RestErrorResponse> processBadRequestException(Exception ex) {
//        log.error(ex.getClass().getName() + " caught", ex);
//        ResponseEntity responseEntity = new ResponseEntity<>(
//                new RestErrorResponse(HttpStatus.BAD_REQUEST,
//                        ex.getMessage()), HttpStatus.BAD_REQUEST);
//
//        return responseEntity;
//    }

    /**
     * Method to handle RestAPIException
     */
    @ExceptionHandler(RestAPIException.class)
    @Trace(type = LogEventType.EXCEPTION)
    private ResponseEntity<RestErrorResponse> processRestAPIException(RestAPIException ex) {
        if (!HttpStatus.NOT_FOUND.equals(ex.getErrorCode())) {
            log.error("RestAPIException caught: ", ex);
        }
        ResponseEntity responseEntity;
        if (ex.getErrorCode().equals(HttpStatus.NOT_FOUND)) {
            responseEntity = new ResponseEntity<>(
                    new RestErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage()),
                    HttpStatus.NOT_FOUND);
        } else if (ex.getErrorCode().equals(HttpStatus.BAD_REQUEST)) {
            responseEntity = new ResponseEntity<>(
                    new RestErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage()),
                    HttpStatus.BAD_REQUEST);
        } else {
            log.error(ErrorMessages.INTERNAL_SERVER_ERROR, ex);
            responseEntity = new ResponseEntity<>(new RestErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                    ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * Catching all HttpRequestMethodNotSupportedException when unsupported method Rest call is made
     */
//    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
//    @Trace(type = LogEventType.EXCEPTION)
//    public ResponseEntity<RestErrorResponse> unsupportedHttpMethodCallHandling(
//            HttpRequestMethodNotSupportedException ex) {
//        log.error("HttpRequestMethodNotSupportedException caught: ", ex);
//        StringBuilder errorInfo = new StringBuilder();
//        errorInfo.append(ex.getMethod());
//        errorInfo.append(ErrorMessages.ERROR_INFO_UNSUPPORTED_METHOD);
//        errorInfo.append(ex.getSupportedHttpMethods().toString());
//        RestErrorResponse restError =
//                new RestErrorResponse(HttpStatus.METHOD_NOT_ALLOWED, errorInfo.toString());
//        return new ResponseEntity<>(restError, HttpStatus.METHOD_NOT_ALLOWED);
//    }

//    @ExceptionHandler(value = InvalidHeaderException.class)
//    @Trace(type = LogEventType.EXCEPTION)
//    public ResponseEntity<RestErrorResponse> invalidHeaderExceptionHandling(
//            HttpRequestMethodNotSupportedException ex) {
//        log.error("InvalidHeaderException caught: ", ex);
//        StringBuilder errorInfo = new StringBuilder();
//        errorInfo.append(ex.getMethod());
//        errorInfo.append(ErrorMessages.INVALID_HEADER_EXCEPTION);
//        errorInfo.append(ex.getSupportedHttpMethods().toString());
//        RestErrorResponse restError =
//                new RestErrorResponse(HttpStatus.EXPECTATION_FAILED, errorInfo.toString());
//        return new ResponseEntity<>(restError, HttpStatus.EXPECTATION_FAILED);
//    }
}
