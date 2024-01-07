package com.danielhahn.shoppinglistapi;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService service;

    @GetMapping
    public List<Todo> getAllTodos() {
        return service.findAll();
    }

    // Other request mappings
}

