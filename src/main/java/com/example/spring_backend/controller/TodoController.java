package com.example.spring_backend.controller;

import java.util.List;

import com.example.spring_backend.repsitory.TodoRepository;
import com.example.spring_backend.model.Todo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoRepository repository;

    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Todo> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/user/{user_id}")
    public List<Todo> getByUserId(@PathVariable Long user_id) {
        return repository.getByUserId(user_id);
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return repository.save(todo);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo todo) {
        todo.setId(id);
        return repository.save(todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
