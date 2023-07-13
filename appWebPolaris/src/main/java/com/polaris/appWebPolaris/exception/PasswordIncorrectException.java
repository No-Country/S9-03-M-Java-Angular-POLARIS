package com.polaris.appWebPolaris.exception;

public class PasswordIncorrectException extends RuntimeException {

    public PasswordIncorrectException() {
        super("La contraseña es inválida.");
    }
}
