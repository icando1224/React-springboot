package com.example.Springbot_todo.dao;

import com.example.Springbot_todo.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository("mapDb")
public class TodoDataAccessServiceList implements TodoDao {
    //private static List<Todo> listDB=new ArrayList<>();
//    TodoDataAccessServiceList(){
//        listDB.add(new Todo(UUID.randomUUID(),"hhhh",false));
//    }
    private static Map<UUID,Todo> mapDb=new HashMap<>();
    @Override
    public List<Todo> insertTodo(UUID id, Todo todo) {
        mapDb.put(id,new Todo(id,todo.getTitle(),todo.isCompleted()));
        //listDB.add(new Todo(id,todo.getTitle(),todo.isCompleted()));
        return selectAllTodos();
    }

    @Override
    public List<Todo> selectAllTodos() {
        List<Todo> listTodo=new ArrayList<>();
        for(UUID key:mapDb.keySet()){
            listTodo.add(mapDb.get(key));
        }
        return listTodo;
    }

    @Override
    public List<Todo> deleteTodo(UUID id) {
        mapDb.remove(id);
        return selectAllTodos();
    }

    @Override
    public boolean updateTodo(UUID id, boolean completed) {
        Todo aTodo=mapDb.get(id);
        aTodo.setCompleted(completed);
        mapDb.replace(id,aTodo);
        //System.out.println(mapDb.get(id).isCompleted());
        return mapDb.get(id).isCompleted();
    }

}
