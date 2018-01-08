package com.contaazul.robo.exception;

import com.contaazul.robo.controller.MovementController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RoboDefaultExceptionHandler {

    public static final Logger LOGGER = LoggerFactory.getLogger(MovementController.class);

    @ExceptionHandler(InvalidPositionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<String> invalidPositionException(InvalidPositionException ex) {
        LOGGER.error("Invalid Position", ex);
        return new ResponseEntity("Invalid position", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCommandException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<String> invalidCommandException(InvalidCommandException ex) {
        LOGGER.error("Invalid Command", ex);
        return new ResponseEntity("Invalid Command", HttpStatus.BAD_REQUEST);
    }

}
