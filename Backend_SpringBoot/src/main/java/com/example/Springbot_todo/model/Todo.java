package com.example.Springbot_todo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Todo {
    private final UUID id;
    private final String title;
    private boolean completed;

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed){
        this.completed=completed;
    }

    public Todo(@JsonProperty("id") UUID id, @JsonProperty("title") String title,@JsonProperty("completed") boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
}
