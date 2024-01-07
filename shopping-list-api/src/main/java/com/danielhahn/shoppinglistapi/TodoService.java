package com.danielhahn.shoppinglistapi;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public List<Todo> findAll() {
        return repository.findAll();
    }

    // Other business methods
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public void createTodo(Todo todo) {
        repository.save(todo);
    }

    public Todo getTodo(String ItemName) {
        return repository.findById(ItemName).orElse(null);
    }

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    public void deleteTodo(String ItemName) {
        repository.deleteById(ItemName);
    }
}

