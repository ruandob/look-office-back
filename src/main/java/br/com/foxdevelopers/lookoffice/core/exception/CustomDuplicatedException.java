package br.com.foxdevelopers.lookoffice.core.exception;

public class CustomDuplicatedException extends RuntimeException {

    public CustomDuplicatedException(String msg) {
        super(msg);
    }
}