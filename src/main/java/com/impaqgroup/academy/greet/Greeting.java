package com.impaqgroup.academy.greet;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * Created by impaq on 18.03.15.
 */
@Entity
public class Greeting {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Temporal(TIMESTAMP)
    private Date timestamp;

    protected Greeting() {
        // required by ORM
    }

    public Greeting(String name, Date timestamp) {
        this.name = name;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
