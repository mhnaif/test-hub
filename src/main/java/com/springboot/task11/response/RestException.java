package com.springboot.task11.response;


import com.springboot.task11.execpetion.AccountNotFoundException;
import com.springboot.task11.execpetion.CustomerNotFoundException;
import com.springboot.task11.execpetion.ErrorBodyMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus
public class RestException {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorBodyMessage> AccountException(AccountNotFoundException exception){
        ErrorBodyMessage message = new ErrorBodyMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorBodyMessage> CustomerException(CustomerNotFoundException exception) {
        ErrorBodyMessage message = new ErrorBodyMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
