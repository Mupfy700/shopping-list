package com.danielhahn.shoppinglistapi;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*")

public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    List<Todo> todoList = new ArrayList<>();

    @GetMapping("/list")
    public List<Todo> getAllTodos() {
        return todoService.findAll();
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<Todo> getTodoByName(@PathVariable String name) {
        Todo todo = todoService.getTodo(name);
        if (todo != null) {
            return ResponseEntity.ok(todo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addTodo")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addString(@RequestBody String todoName) {
        System.out.println("Creating todo " + todoName);
        Todo todo = new Todo();
        todo.setItemName(todoName);
        if (todoList.contains(todo)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Todo " + todoName + " already exists");
        } else {
            todoService.createTodo(todo);
            todoList.add(todo);
            return ResponseEntity.status(HttpStatus.CREATED).body("Todo " + todoName + " created successfully");
        }
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteTodo(@PathVariable String name) {
        Todo todo = todoService.getTodo(name);
        if (todo != null) {
            todoService.deleteTodo(name);
            todoList.remove(todo);
            return ResponseEntity.ok("Todo " + name + " deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

    