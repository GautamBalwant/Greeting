package com.example.Greeting.repo;

import com.example.Greeting.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepo extends CrudRepository<Greeting, Integer> {
}
