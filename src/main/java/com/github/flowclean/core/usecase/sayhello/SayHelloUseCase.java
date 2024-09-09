package com.github.flowclean.core.usecase.sayhello;

import com.github.flowclean.core.model.Greeting;
import com.github.flowclean.core.port.GreetingsFormulatorOutputPort;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class SayHelloUseCase implements SayHelloInputPort {

    SayHelloPresenterOutputPort presenter;
    GreetingsFormulatorOutputPort greetingsFormulatorOps;

    @Override
    public void issueGreeting(String addresseeName, String languageTag) {
        Greeting greeting;
        String greetingsFormula;
        try {
            // create a valid domain model object from input parameters
            greeting = new Greeting(addresseeName, languageTag);

            // obtain appropriate greetings formula, i.e. translated template
            greetingsFormula = greetingsFormulatorOps.translatedGreetingsTemplate(greeting);

            // successful outcome: present the greeting
            presenter.presentGreeting(greeting, greetingsFormula);
        } catch (Exception e) {
            // exceptional outcome: present an error
            presenter.presentError(e);
        }
    }
}
