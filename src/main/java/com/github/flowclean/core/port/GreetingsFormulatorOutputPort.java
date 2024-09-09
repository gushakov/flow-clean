package com.github.flowclean.core.port;

import com.github.flowclean.core.model.Greeting;

public interface GreetingsFormulatorOutputPort {

    String translatedGreetingsTemplate(Greeting greeting);

}
