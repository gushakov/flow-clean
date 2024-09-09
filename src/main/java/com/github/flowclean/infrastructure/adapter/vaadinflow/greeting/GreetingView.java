package com.github.flowclean.infrastructure.adapter.vaadinflow.greeting;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@StyleSheet("https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GreetingView extends VerticalLayout {

    // view elements which need package-private accessors (for binding from view-model)
    @Getter(AccessLevel.PACKAGE)
    TextField tf;
    @Getter(AccessLevel.PACKAGE)
    ComboBox<Language> cb;
    @Getter(AccessLevel.PACKAGE)
    Button btn1;

    // view elements which will only be accessed locally from the view
    Div greetingDiv;
    Div greetingAlert;
    Div errorDiv;
    Div errorAlert;

    public GreetingView() {
        setMargin(true);

        Div container = new Div();
        container.setClassName("container");

        Div row = new Div();
        row.setClassName("row d-flex align-items-end");

        tf = new TextField();
        tf.setLabel("Name");
        tf.setClassName("col-2");
        tf.setValue("George");
        row.add(tf);

        cb = new ComboBox<>();
        cb.setLabel("Language");
        cb.setItemLabelGenerator(Language::getLabel);
        cb.setItems(Language.values());
        cb.setClassName("col-2");
        cb.setValue(Language.English);
        row.add(cb);

        btn1 = new Button("Say hello");
        btn1.setClassName("col-2");
        row.add(btn1);

        greetingDiv = new Div();
        greetingDiv.setClassName("row mt-3");
        greetingDiv.setVisible(false);

        greetingAlert = new Div();
        greetingAlert.setClassName("col-6 alert alert-info");
        greetingAlert.setText("Hello World!");
        greetingDiv.add(greetingAlert);

        errorDiv = new Div();
        errorDiv.setClassName("row mt-3");
        errorDiv.setVisible(false);

        errorAlert = new Div();
        errorAlert.setClassName("col-6 alert alert-danger");
        errorAlert.setText("Error");
        errorDiv.add(errorAlert);

        container.add(row, greetingDiv, errorDiv);
        add(container);
    }

    // package private methods for view manipulation from the view-model

    void showGreeting(String text) {
        errorDiv.setVisible(false);
        greetingDiv.setVisible(true);
        greetingAlert.setText(text);
    }

    void showError(String text) {
        greetingDiv.setVisible(false);
        errorDiv.setVisible(true);
        errorAlert.setText(text);
    }
}
