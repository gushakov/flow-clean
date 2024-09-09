package com.github.flowclean.infrastructure.adapter.vaadinflow.greeting;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.dom.Element;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.util.Optional;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GreetingViewModel {

    // Flow binder for this view-model
    Binder<GreetingViewModel> binder = new Binder<>(GreetingViewModel.class);

    // root element of the view
    GreetingView view;

    // bean properties bound to the view
    @Getter
    @Setter
    @NonFinal
    String name;

    @Getter
    @Setter
    @NonFinal
    Language selectedLanguage;

    public GreetingViewModel(ComponentEventListener<ClickEvent<Button>> sayHelloHandler) {
        view = new GreetingView();

        // bind view elements to the view-model properties
        binder.bind(view.getTf(), "name");
        binder.bind(view.getCb(), "selectedLanguage");

        // register event handlers with appropriate view elements
        view.getBtn1().addClickListener(sayHelloHandler);
    }

    Element getViewElement() {
        return Optional.ofNullable(view).map(VerticalLayout::getElement).orElse(null);
    }

    /**
     * Updates this view-model by writing all values from the view into the corresponding
     * properties.
     *
     * @throws IllegalStateException if there was an error binding the values of the view
     */
    public void update() {
        try {
            binder.writeBean(this);
        } catch (ValidationException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Updates the view with the current values of the corresponding properties of this
     * view-model.
     */
    public void updateView() {
        binder.readBean(this);
    }

    String getSelectedLanguageTag() {
        return Optional.ofNullable(selectedLanguage).map(Language::getTag).orElse(null);
    }

    void showGreeting(String text) {
        view.showGreeting(text);
    }

    void showError(String text) {
        view.showError(text);
    }

}
