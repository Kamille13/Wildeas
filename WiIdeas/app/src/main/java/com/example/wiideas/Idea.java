package com.example.wiideas;

import android.os.Parcel;
import android.os.Parcelable;

public class Idea implements Parcelable {

    String tittle;
    String content;
    String image;


    //Ideas Constructor
    public Idea(String tittle, String content, String image) {
        this.tittle = tittle;
        this.content = content;
        this.image = image;
    }


    protected Idea(Parcel in) {
        tittle = in.readString();
        content = in.readString();
        image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tittle);
        dest.writeString(content);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getTittle() {
        return tittle;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage(String image) {
        this.image = image;
    }


}


