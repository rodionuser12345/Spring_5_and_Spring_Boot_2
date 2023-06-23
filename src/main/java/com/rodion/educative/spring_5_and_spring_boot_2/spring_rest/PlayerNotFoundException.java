package com.rodion.educative.spring_5_and_spring_boot_2.spring_rest;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException() {
        super();
    }

    public PlayerNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PlayerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlayerNotFoundException(String message) {
        super(message);
    }

    public PlayerNotFoundException(Throwable cause) {
        super(cause);
    }
}
