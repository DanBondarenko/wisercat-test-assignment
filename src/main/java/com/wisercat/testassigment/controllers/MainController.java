package com.wisercat.testassigment.controllers;

import com.wisercat.testassigment.configuration.ExposedMessageSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping(path = "/")
public class MainController {
    private final ExposedMessageSource messageSource;

    @Autowired
    public MainController(ExposedMessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @GetMapping
    public String index() {
        return "index";
    }

    @ModelAttribute("messages")
    Map<String, String> getMessages(Locale locale) {
        return messageSource.getMessages(locale);
    }
}
