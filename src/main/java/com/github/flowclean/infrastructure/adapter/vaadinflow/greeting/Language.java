package com.github.flowclean.infrastructure.adapter.vaadinflow.greeting;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum Language {

    English("en", "English"),
    French("fr", "Français"),
    Klingon("_k", "Klingon");

    @Getter(AccessLevel.PACKAGE)
    String tag;

    @Getter(AccessLevel.PACKAGE)
    String label;

    Language(String tag, String label) {
        this.tag = tag;
        this.label = label;
    }
}
