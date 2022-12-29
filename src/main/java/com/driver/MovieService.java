package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepo;

    public void addMovie(Movie movies){
        movieRepo.addMovieToDB(movies);
    }

    public void addDirector(Director director){
        movieRepo.addDirectorToDB(director);
    }

    public void createMovieDirectorPair(String movie, String director){
        movieRepo.addMovieDirectorToDB(movie, director);
    }

    public Movie MovieByNames(String movie){
        return movieRepo.getMovieFromDB(movie);
    }

    public Director getDirectorNames(String director){
        return movieRepo.getDirectorFromDB(director);
    }

    public List<String> getMoviesFromDirector(String director){
        return movieRepo.MoviesFromDirector(director);
    }

    public List<String> findAllMovies(){
        return movieRepo.getAllMoviesFromDB();
    }

    public void deleteDirector(String director){
        movieRepo.deleteDirectorFromDB(director);
    }

    public void deleteAllDirectors(){
        movieRepo.deleteAllDirector();
    }
}
