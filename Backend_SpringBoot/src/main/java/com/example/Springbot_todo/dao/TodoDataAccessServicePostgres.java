package com.example.Springbot_todo.dao;

import com.example.Springbot_todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository("postgres")
public class TodoDataAccessServicePostgres implements TodoDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public TodoDataAccessServicePostgres(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Todo> insertTodo(UUID id, Todo todo) {
        final String sql="Insert into todo values(?,?,?)";
        Object[] args=new Object[]{id,todo.getTitle(),todo.isCompleted()};
        jdbcTemplate.update(sql,args);
        return selectAllTodos();
    }

    @Override
    public List<Todo> selectAllTodos() {
        final String sql="SELECT id,title,completed from todo";
        List<Todo> listTodo=jdbcTemplate.query(sql,(resultSet,i)->{
            return new Todo(UUID.fromString(resultSet.getString("id")),resultSet.getString("title"),resultSet.getBoolean("completed"));
        });
        return listTodo;
    }

    @Override
    public List<Todo> deleteTodo(UUID id) {
        final String sql="DELETE from todo where id=?";
        Object[] args=new Object[]{id};
        jdbcTemplate.update(sql,args);
        return selectAllTodos();
        //return null;
    }

    @Override
    public boolean updateTodo(UUID id, boolean completed) {
        final String sql="UPDATE todo set completed=? where id=?";
        Object[] args=new Object[]{completed,id};
        jdbcTemplate.update(sql,args);
        return completed;
    }
}
