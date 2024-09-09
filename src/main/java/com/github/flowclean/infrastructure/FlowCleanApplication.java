package com.github.flowclean.infrastructure;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Theme(themeClass = Lumo.class)
@SpringBootApplication
public class FlowCleanApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(FlowCleanApplication.class, args);
    }

}
