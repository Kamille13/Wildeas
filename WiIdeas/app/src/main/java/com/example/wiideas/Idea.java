package com.example.wiideas;

import android.os.Parcel;
import android.os.Parcelable;

public class Idea implements Parcelable {

    String tittle;
    String content;


    //Ideas Constructor
    public Idea(String tittle, String content) {
        this.tittle = tittle;
        this.content = content;
    }


    //Ideas getter and setters

    protected Idea(Parcel in) {
        tittle = in.readString();
        content = in.readString();
    }

    public static final Creator<Idea> CREATOR = new Creator<Idea>() {
        @Override
        public Idea createFromParcel(Parcel in) {
            return new Idea(in);
        }

        @Override
        public Idea[] newArray(int size) {
            return new Idea[size];
        }
    };

    public String getIdeaTittle() {
        return this.tittle;
    }

    public String getIdeaContent() {
        return this.content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tittle);
        dest.writeString(content);
    }
}


