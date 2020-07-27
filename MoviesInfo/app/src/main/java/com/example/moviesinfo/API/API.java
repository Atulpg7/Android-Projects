package com.example.moviesinfo.API;

public class API {

     final String IMAGE_URL="https://image.tmdb.org/t/p/w500/";
     final String MOVIE_URL="https://api.themoviedb.org/3/movie/";
     final String API_KEY="?api_key=513bbf06e53d030b4e378e037e757bad";

    public  String getImageUrl() {
        return IMAGE_URL;
    }

    public  String getMovieUrl() {
        return MOVIE_URL;
    }

    public  String getApiKey() {
        return API_KEY;
    }
}
