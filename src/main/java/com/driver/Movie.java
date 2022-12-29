package com.driver;

public class Movie {
    private String name;
    private int durationInMinutes;
    private double imdbRating;

    public Movie(){}

    public Movie(String name, int duration, double imdb){
        this.name = name;
        this.durationInMinutes = duration;
        this.imdbRating = imdb;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDurationInMinutes() {
        return durationInMinutes;
    }
    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
    public double getImdbRating() {
        return imdbRating;
    }
    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
