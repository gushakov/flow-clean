package com.github.flowclean.core.model;

import com.github.flowclean.core.GenericGreetingError;

public class InvalidDomainObjectError extends GenericGreetingError {
    public InvalidDomainObjectError(String errorMessage) {
        super(errorMessage);
    }
}
