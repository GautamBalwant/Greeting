package com.example.Greeting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Greeting {

    @Id
    @GeneratedValue
    private Integer id;
    private  String greet;

    public Greeting() {
    }

    public Integer getId() {
        return id;
    }

    public String getGreet() {
        return greet;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGreet(String greet) {
        this.greet = greet;
    }
}
