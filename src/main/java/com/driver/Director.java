package com.driver;

public class Director {
    private String name;
    private int numberOfMovies;
    private double imbdRating;

    public Director(){}

    public Director(String name, int Movies, double imbdRating){
        this.name = name;
        this.numberOfMovies = Movies;
        this.imbdRating = imbdRating;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImbdRating() {
        return imbdRating;
    }

    public void setImbdRating(double imbdRating) {
        this.imbdRating = imbdRating;
    }
}