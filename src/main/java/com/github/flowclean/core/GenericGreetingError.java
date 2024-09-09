package com.github.flowclean.core;

public class GenericGreetingError extends RuntimeException {
    public GenericGreetingError(String message) {
        super(message);
    }

    public GenericGreetingError(String message, Throwable cause) {
        super(message, cause);
    }
}
