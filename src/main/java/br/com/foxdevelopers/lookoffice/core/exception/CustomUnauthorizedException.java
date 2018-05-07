package br.com.foxdevelopers.lookoffice.core.exception;

public class CustomUnauthorizedException extends RuntimeException {

    public CustomUnauthorizedException(String msg) {
        super(msg);
    }
}