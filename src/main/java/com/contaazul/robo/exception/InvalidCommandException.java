package com.contaazul.robo.exception;

public class InvalidCommandException extends RuntimeException {

    public InvalidCommandException(final String message){
        super(message);
    }
}
