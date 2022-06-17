package com.example.greetingapp.services;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;

import java.util.List;

public interface IGeetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);
    List<Greeting> getAllgreeings();
    String deleteMessageById(long id);
}
