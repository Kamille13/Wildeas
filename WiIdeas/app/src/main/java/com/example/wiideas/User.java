package com.example.wiideas;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class User extends ArrayList<Idea>  implements Parcelable {

    private String firstname;
    private String name;
    private ArrayList<Idea> idea = new ArrayList<>();


    //User Contructor
    public User(String firstname, String name, Idea idea) {
        this.firstname = firstname;
        this.name = name;
        this.idea.add(idea);
    }


    protected User(Parcel in) {
        firstname = in.readString();
        name = in.readString();
        idea = in.createTypedArrayList(Idea.CREATOR);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getFirstname() {
        return firstname;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Idea> getIdea() {
        return idea;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdea(ArrayList<Idea> idea) {
        this.idea = idea;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstname);
        dest.writeString(name);
        dest.writeTypedList(idea);
    }
}
