package com.github.flowclean.infrastructure.adapter.i18n;

import com.github.flowclean.core.model.Greeting;
import com.github.flowclean.core.port.GreetingsFormulatorOutputPort;
import com.github.flowclean.core.port.GreetingsTranslationError;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

/**
 * Secondary adapter for {@linkplain GreetingsFormulatorOutputPort} which
 * uses Spring's {@linkplain ResourceBundleMessageSource} based on local
 * properties files to provide translated greetings template.
 */
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class GreetingsTranslator implements GreetingsFormulatorOutputPort {

    ResourceBundleMessageSource greetingsBundle;

    @Override
    public String translatedGreetingsTemplate(Greeting greeting) {
        try {
            return greetingsBundle.getMessage("standard.greeting", null, greeting.getLocale());
        } catch (NoSuchMessageException e) {
            // wrap adapter's technical error into an appropriate domain error
            throw new GreetingsTranslationError("Could not translate greeting for locale: %s"
                    .formatted(greeting.getLocale()), e);
        }
    }
}
