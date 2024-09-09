package com.github.flowclean.core.usecase.sayhello;

import com.github.flowclean.core.model.Greeting;

public interface SayHelloPresenterOutputPort {

    void presentError(Exception e);

    void presentGreeting(Greeting greeting, String greetingsFormula);
}
