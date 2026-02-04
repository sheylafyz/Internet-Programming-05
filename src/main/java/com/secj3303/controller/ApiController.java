package com.secj3303.controller;

import my.utm.healthhub.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api/person")
    public Person getPerson() {
        return new Person("Siti", 2002, 55, 1.60);
    }
}
