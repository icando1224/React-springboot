package com.example.Springbot_todo.api;

import com.example.Springbot_todo.model.Todo;
import com.example.Springbot_todo.service.TodoService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/vi/todo")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
    private final TodoService todoService;
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public List<Todo> addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }
    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodo();
    }
    @DeleteMapping(path="/{id}")
    public List<Todo> deleteAtodo(@PathVariable UUID id){
        return todoService.deleteATodo(id);
    }

    @PutMapping(path="/{id}/{completed}")
    public boolean updateATodo(@PathVariable UUID id, @PathVariable boolean completed){
        return todoService.updateTodo(id,completed);
    }

}
