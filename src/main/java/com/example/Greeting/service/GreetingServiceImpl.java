package com.example.Greeting.service;

import com.example.Greeting.model.Greeting;
import com.example.Greeting.repo.GreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingServiceImpl implements  GreetingService{

    private GreetingRepo greetingRepo;

    public GreetingServiceImpl(GreetingRepo greetingRepo) {
        this.greetingRepo = greetingRepo;
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepo.findAll();
    }

    @Override
    public Optional<Greeting> getGreeting(Integer id) {
       return greetingRepo.findById(id);

    }

    @Override
    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepo.save(greeting);
    }

    @Override
    public Greeting updateGreeting(Greeting greeting) {
        return greetingRepo.save(greeting);
    }

    @Override
    public Boolean deleteGreeting(Integer id) {
         greetingRepo.deleteById(id);
         return true;
    }
}
