package com.example.movieratingwithhystrix.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieRatings {

    private String id;
    private Movie movie;
    private List<Rating> ratings;

    public MovieRatings() {}

    public MovieRatings(String id, Movie movie, List<Rating> ratings) {
        this.id = id;
        this.movie = movie;
        this.ratings = ratings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
