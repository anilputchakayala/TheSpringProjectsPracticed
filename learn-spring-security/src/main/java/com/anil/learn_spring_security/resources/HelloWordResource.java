package com.anil.learn_spring_security.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordResource {

    @GetMapping("/hello-world")
    public String helloWorld( @RequestBody UserDetails userDetails){
        return "Hello World";
    }
}
