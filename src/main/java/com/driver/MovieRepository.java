package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(){
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.directorMovieMapping = new HashMap<>();
    }

    public void addMovieToDB(Movie movie){
        String key = movie.getName();
        movieMap.put(key, movie);
    }

    public void addDirectorToDB(Director director){
        String key = director.getName();
        directorMap.put(key, director);
    }

    public void addMovieDirectorToDB(String movie, String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            List<String> currMoviesByDirector = new ArrayList<>();

            if(directorMovieMapping.containsKey(director))
                currMoviesByDirector = directorMovieMapping.get(director);
            currMoviesByDirector.add(movie);
            directorMovieMapping.put(director, currMoviesByDirector);
        }
    }

    public Movie getMovieFromDB(String movie){
        return movieMap.get(movie);
    }

    public Director getDirectorFromDB(String director){
        return directorMap.get(director);
    }

    public List<String> MoviesFromDirector(String director){
        List<String> movieList = new ArrayList<>();
        if(directorMovieMapping.containsKey(director))
            movieList = directorMovieMapping.get(director);
        return movieList;
    }

    public List<String> getAllMoviesFromDB(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirectorFromDB(String director){
        List<String> movieList = new ArrayList<>();
        if(directorMovieMapping.containsKey(director)){
            movieList = directorMovieMapping.get(director);
            for(String Movie : movieList){
                if(movieMap.containsKey(Movie)){
                    movieMap.remove(Movie);
                }
            }
            directorMovieMapping.remove(director);
        }
        if(directorMap.containsKey(director)){
            directorMap.remove(director);
        }
    }

    public void deleteAllDirector(){
        HashSet<String> movieSet = new HashSet<>();
        directorMap = new HashMap<>();

        for(String director : directorMovieMapping.keySet()){
            for(String movie : directorMovieMapping.get(director)){
                movieSet.add(movie);
            }
        }
        for(String movie : movieSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
        directorMovieMapping = new HashMap<>();
    }
}