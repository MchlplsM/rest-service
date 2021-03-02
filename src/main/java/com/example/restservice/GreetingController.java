package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
                //It is the Controller Layer/AP Layer (Will receive and handle HTTP requests like GET,POST etc)
@RestController //It is going to be a class that will define REQUEST MAPPING
public class GreetingController {

    //With -final- keyword you are not able to change the value.
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong(); //A way to set the ID for that greeting

    // /gretting?name=Marios that will print Hello Marios!
    @GetMapping("/greeting")//This is going to be a get request for /greeting
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
