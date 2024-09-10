package com.github.flowclean.core.model;

import lombok.Value;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

@Value
public class Greeting {

    String addressee;
    Locale locale;

    /**
     * Constructs a greeting for a given {@code addressee} in the provided
     * {@code locale}.
     *
     * @param addressee   name of a person to whom the greeting is addressed
     * @param languageTag tag for the language of the locale
     * @throws InvalidDomainObjectError if the name of the addressee or the locale
     *                                  are not valid (empty, not supported)
     */
    public Greeting(String addressee, String languageTag) {
        this.addressee = validAddressee(addressee);
        this.locale = validLocale(languageTag);
    }

    private String validAddressee(String addressee) {
        return Optional.ofNullable(addressee)
                .filter(s -> !s.isEmpty())
                .filter(s -> !s.isBlank())
                .map(String::trim)
                .orElseThrow(() -> new InvalidDomainObjectError("Name of the addressee is invalid."));
    }

    private Locale validLocale(String languageTag) {
        String tag = Optional.ofNullable(languageTag)
                .map(String::trim)
                .map(String::toLowerCase)
                .orElseThrow(() -> new InvalidDomainObjectError("Locale of the greeting must not be null."));

        return Arrays.stream(Locale.getISOLanguages())
                .filter(code -> code.equals(tag))
                .findAny()
                .map(Locale::forLanguageTag)
                .orElseThrow(() -> new InvalidDomainObjectError("Sorry, this language is not supported yet."));
    }

}
