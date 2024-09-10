package com.github.flowclean.infrastructure.adapter.vaadinflow.greeting;

import com.github.flowclean.core.usecase.sayhello.SayHelloInputPort;
import com.github.flowclean.infrastructure.SpringUtils;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Tag("greeting-controller")
@Route(value = "")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GreetingController extends Component implements RouterLayout {

    GreetingViewModel viewModel;

    public GreetingController() {

        // initialize view-model
        viewModel = new GreetingViewModel(handleSayHello());

    }

    private ComponentEventListener<ClickEvent<Button>> handleSayHello() {
        return event -> {
            // update bound properties of the view-model
            viewModel.update();
            // execute the use case passing input parameters bound to the view-model
            useCase().issueGreeting(viewModel.getName(), viewModel.getSelectedLanguageTag());
        };
    }

    private SayHelloInputPort useCase() {
        // get the use case from the context passing the view-model
        return SpringUtils.getBean(SayHelloInputPort.class, viewModel);
    }

    @Override
    public Element getElement() {
        return viewModel.getViewElement();
    }
}
