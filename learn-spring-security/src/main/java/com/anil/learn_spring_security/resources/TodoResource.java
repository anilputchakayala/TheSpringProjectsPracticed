package com.anil.learn_spring_security.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoResource {

    public static final List<Todo> TODOS_LIST = new ArrayList<>(List.of(new Todo("in28minutes", "Learn Spring Framework"),
            new Todo("telusko", "Learn Java")));
    private static final Logger log = LoggerFactory.getLogger(TodoResource.class);

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos(){
        return TODOS_LIST;
    }
    @GetMapping("/users/{username}/todos")
    public Todo retrieveAllTodosForSpecificUser(@PathVariable String username){
        return TODOS_LIST.get(0);
    }

    @PostMapping("/username/{username}/todos")
    public void createTodoForSpecificUser(@PathVariable String username, @RequestBody Todo todo){
        log.info("Creating a todo {} for user {}", todo, username);
        TODOS_LIST.add(todo);
    }
}

record Todo(String username, String description){}
