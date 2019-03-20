package com.example.listview;

public class Todo {
    private String description;
    private String date;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public Todo(String description, String date) {
        this.description = description;
        this.date = date;
    }
}
