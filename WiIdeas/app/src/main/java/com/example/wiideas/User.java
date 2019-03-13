package com.example.wiideas;

import java.util.ArrayList;

public class User {

    String firstname;
    String name;
    ArrayList<Idea> idea = new ArrayList<>();


    //User Contructor
    public User(String firstname, String name, Idea idea) {
        this.firstname = firstname;
        this.name = name;
        this.idea.add(idea);
    }

    //User getter and setters
    public String getUserFirstName() {
        return this.firstname;
    }

    public String getUserName() {
        return this.name;
    }

    public ArrayList<Idea> getIdea(){

        return this.idea;

    }
}
    /*public void isUserFirstName(){
        this.firstname = firstname;
    }

    public void isUsertName(){
        this.firstname = name;
    }

    //Search an idea into the list

    public int seachIdeas(String tittle, ArrayList<Idea> idea) {

        return idea.indexOf(tittle);

    }
}*/
