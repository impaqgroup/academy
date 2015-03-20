package com.impaqgroup.academy.greet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by impaq on 18.03.15.
 */
@Service
public class GreetingService {

    private GreetingRepository repository;

    @Autowired
    public GreetingService(GreetingRepository repository) {
        this.repository = repository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Greeting greet(String name) {
        Greeting greeting = new Greeting(name, new Date());
        repository.save(greeting);
        return greeting;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public long count(Greeting greeting) {
        return repository.countByName(greeting.getName());
    }
}
