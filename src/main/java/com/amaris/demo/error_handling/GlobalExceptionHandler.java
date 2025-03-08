package com.amaris.demo.error_handling;

import com.amaris.demo.error_handling.exception.NotFoundException;
import com.amaris.demo.response.CustomErrorResponse;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<CustomErrorResponse> handleTypeMismatch(TypeMismatchException ex)
    {
        String errorMessage = "";

        Class<?> requiredType = ex.getRequiredType();
        Object incorrectValue = ex.getValue();

        if (requiredType == null)
            errorMessage = String.format("The value '$%s' is not a correct type", incorrectValue);
        else
        {
            String[] typesSplit = requiredType.getName().split("\\.");

            errorMessage = String.format("The value '%s' is not of type '%s'.", incorrectValue, typesSplit[typesSplit.length - 1]);
        }

        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleMismatchRequest(HttpMessageNotReadableException exc)
    {
        String errorMessage = exc.getMessage();

        CustomErrorResponse errorsResponse = new CustomErrorResponse();

        errorsResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorsResponse.setMessage(errorMessage);

        // Return an error response.
        return new ResponseEntity<>(errorsResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundErrors(Exception ex)
    {
        CustomErrorResponse errorResponse = new CustomErrorResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<CustomErrorResponse> handleException(Exception ex)
    {
        CustomErrorResponse errorResponse = new CustomErrorResponse();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
