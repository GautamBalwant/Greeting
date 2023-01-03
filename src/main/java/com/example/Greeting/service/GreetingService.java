package com.example.Greeting.service;

import com.example.Greeting.model.Greeting;

import java.util.List;
import java.util.Optional;

public interface GreetingService {

    public List<Greeting> getAllGreetings();
    public Optional<Greeting> getGreeting(Integer id);
    public Greeting saveGreeting(Greeting greeting);
    public Greeting updateGreeting(Greeting greeting);
    public Boolean deleteGreeting(Integer id);

}
