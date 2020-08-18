package com.wisercat.testassigment.configuration;

import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.stream.Collectors;


public class ExposedMessageSource extends ResourceBundleMessageSource {
    private final String basename;

    public ExposedMessageSource(String basename) {
        this.basename = basename;
        setBasename(basename);
        setDefaultEncoding("UTF-8");

    }

    public Map<String, String> getMessages(Locale locale) {
        ResourceBundle bundle = getResourceBundle(basename, locale);
        if (bundle == null) {
            bundle = ResourceBundle.getBundle(basename);
        }

        return bundle.keySet()
            .stream()
            .collect(
                Collectors.toMap(Function.identity(),
                bundle::getString
            ));
    }
}
