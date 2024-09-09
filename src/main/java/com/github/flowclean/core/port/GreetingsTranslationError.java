package com.github.flowclean.core.port;

import com.github.flowclean.core.GenericGreetingError;

public class GreetingsTranslationError extends GenericGreetingError {
    public GreetingsTranslationError(String message, Throwable cause) {
        super(message, cause);
    }
}
