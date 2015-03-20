package com.impaqgroup.academy.greet;

import java.util.Date;

/**
 * Created by impaq on 18.03.15.
 */
public class GreetingRepresentation {

    private String message;
    private Date timestamp;
    private long count;

    public GreetingRepresentation(Greeting greeting, long count) {
        this.message = String.format("Hello %s!", greeting.getName());
        this.timestamp = greeting.getTimestamp();
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public long getCount() {
        return count;
    }
}
