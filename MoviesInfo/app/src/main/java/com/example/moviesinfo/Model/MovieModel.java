package com.example.moviesinfo.Model;

import java.util.ArrayList;

public class MovieModel {

    String title;
    ArrayList<MovieDetails> arrayList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<MovieDetails> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<MovieDetails> arrayList) {
        this.arrayList = arrayList;
    }
}
