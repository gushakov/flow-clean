package com.github.flowclean.infrastructure.adapter.vaadinflow.greeting;

import com.github.flowclean.core.model.Greeting;
import com.github.flowclean.core.usecase.sayhello.SayHelloPresenterOutputPort;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Secondary adapter. Present a friendly message to the user or notify
 * her that an error has occurred.
 */
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class SayHelloPresenter implements SayHelloPresenterOutputPort {
    GreetingViewModel viewModel;

    @Override
    public void presentError(Exception e) {
        try {
            viewModel.showError(e.getMessage());
        } catch (Exception ex) {
            // should not happen
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public void presentGreeting(Greeting greeting, String greetingsFormula) {
        try {
            // format greeting message for the addressee
            String greetingText = greetingsFormula.formatted(greeting.getAddressee());
            // show greeting
            viewModel.showGreeting(greetingText);
        } catch (Exception e) {
            // handle any errors
            presentError(e);
        }
    }
}
