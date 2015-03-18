package com.impaqgroup.academy.greet;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by impaq on 18.03.15.
 */
public interface GreetingRepository extends JpaRepository<Greeting, Long> {

    long countByName(String name);

}
