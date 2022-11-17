package com.example.Springbot_todo.dao;

import com.example.Springbot_todo.model.Todo;

import java.util.List;
import java.util.UUID;

public interface TodoDao {
    List<Todo> insertTodo(UUID id, Todo todo);
    default List<Todo> insertTodo(Todo todo){
        UUID id=UUID.randomUUID();
        return insertTodo(id,todo);
    }
    List<Todo> selectAllTodos();

    List<Todo> deleteTodo(UUID id);
    boolean updateTodo(UUID id, boolean completed);

}
