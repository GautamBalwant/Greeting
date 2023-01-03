package com.example.Greeting.controller;

import com.example.Greeting.model.Greeting;
import com.example.Greeting.service.GreetingService;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Greeting>> findAllGreetings(){

       List<Greeting> greetings = greetingService.getAllGreetings();

       return new ResponseEntity<List<Greeting>>(greetings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greeting> findGreeting(@PathVariable Integer id){
        Optional<Greeting> greeting = greetingService.getGreeting(id);
        return new ResponseEntity<Greeting>(greeting.get(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Greeting> saveGreeting(@RequestBody Greeting greeting){
        Greeting result= greetingService.saveGreeting(greeting);
        if(result == null){
            return new ResponseEntity<Greeting>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
       return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Greeting> updateGreeting(@RequestBody Greeting greeting){
        Greeting result= greetingService.updateGreeting(greeting);
        if(result== null){
            return new ResponseEntity<Greeting>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreeting(@PathVariable Integer id){

       boolean result= greetingService.deleteGreeting(id);
       if(result){
           return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
