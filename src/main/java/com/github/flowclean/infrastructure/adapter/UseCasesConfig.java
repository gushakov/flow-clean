package com.github.flowclean.infrastructure.adapter;

import com.github.flowclean.core.port.GreetingsFormulatorOutputPort;
import com.github.flowclean.core.usecase.sayhello.SayHelloInputPort;
import com.github.flowclean.core.usecase.sayhello.SayHelloUseCase;
import com.github.flowclean.infrastructure.adapter.vaadinflow.greeting.GreetingViewModel;
import com.github.flowclean.infrastructure.adapter.vaadinflow.greeting.SayHelloPresenter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UseCasesConfig {

    GreetingsFormulatorOutputPort greetingsFormulatorOps;

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SayHelloInputPort sayHelloUseCase(@Autowired(required = false) GreetingViewModel viewModel) {
        return new SayHelloUseCase(new SayHelloPresenter(viewModel), greetingsFormulatorOps);
    }

}
