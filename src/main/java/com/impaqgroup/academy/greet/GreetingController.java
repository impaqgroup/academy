package com.impaqgroup.academy.greet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by impaq on 18.03.15.
 */
@RestController
public class GreetingController {

    private GreetingService service;

    @Autowired
    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public GreetingRepresentation greet(
            @RequestParam(value = "name", defaultValue = "world") String name) {

        Greeting greeting = service.greet(name);
        long count = service.count(greeting);

        return new GreetingRepresentation(greeting, count);
    }
}
