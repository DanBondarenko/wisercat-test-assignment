package com.wisercat.testassigment.controllers;

import com.wisercat.testassigment.configuration.ExposedMessageSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Locale;
import java.util.Map;

@ControllerAdvice
public class MessagesControllerAdvice {
    private final ExposedMessageSource messageSource;

    @Autowired
    public MessagesControllerAdvice(ExposedMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ModelAttribute("messagesMap")
    Map<String, String> populateMessages(Locale locale) {
        return messageSource.getMessages(locale);
    }
}
