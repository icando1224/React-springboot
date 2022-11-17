package com.example.Springbot_todo.service;

import com.example.Springbot_todo.dao.TodoDao;
import com.example.Springbot_todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {
    private final TodoDao todoDao;
    @Autowired
    public TodoService(@Qualifier("postgres") TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public List<Todo> addTodo(Todo todo){
        return todoDao.insertTodo(todo);
    }
    public List<Todo> getAllTodo(){
        return todoDao.selectAllTodos();
    }

    public List<Todo> deleteATodo(UUID id){
        return todoDao.deleteTodo(id);
    }

    public boolean updateTodo(UUID id, boolean completed){
        return todoDao.updateTodo(id,completed);
    }
}
