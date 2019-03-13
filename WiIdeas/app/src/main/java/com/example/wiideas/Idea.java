package com.example.wiideas;

public class Idea {

    String tittle;
    String content;

    //Ideas Constructor
    public Ideas(String tittle, String content) {
        this.tittle = tittle;
        this.content = content;
    }

    //Ideas getter and setters

    public String getIdeaTittle(){
        return this.tittle;
    }

    public String getIdeaContent(){
        return this.content;
    }

    public void isIdeaTittle(){
        this.tittle = tittle;
    }

    public void isIdeaContent(){
        this.content = content;
    }

}


    /