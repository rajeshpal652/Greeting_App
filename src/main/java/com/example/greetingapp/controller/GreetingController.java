package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import com.example.greetingapp.services.IGeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.font.ImageGraphicAttribute;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {


    @Autowired
    private IGeetingService greetingService;


    //curl -X GET "http://localhost:8080/greeting" -w "\n"
    @GetMapping(value = {"", "/", "/home"})
    public Greeting addGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
        User user = new User();
        user.setFirstName(name);
        return  greetingService.addGreeting(user);
    }

    @GetMapping("/findbyid/{id}")
    public Greeting getGreetingById(@PathVariable long id) {
        return greetingService.getGreetingById(id);
    }

    @GetMapping("/alllist")
    public List<Greeting> getAllgreeings() {
        return greetingService.getAllgreeings();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMessageById(@PathVariable long id) {
        return this.greetingService.deleteMessageById(id);
    }
}
