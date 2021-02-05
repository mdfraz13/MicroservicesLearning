package com.learning.movieservice.service;

import com.learning.movieservice.beans.Movie;
import com.learning.movieservice.beans.MovieRatings;
import com.learning.movieservice.beans.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieRatingService {

    @Autowired
    private RestTemplate restTemplate;

    public MovieRatings getMovieRatings(String id) {
        final var movieRatings = new MovieRatings();

        final var movieResp = restTemplate.getForEntity("http://movie-service/v1/movie/"+id, Movie.class);

        if (HttpStatus.OK.equals(movieResp.getStatusCode()))
        {
            final var movie = movieResp.getBody();
            System.out.println(movie);
            movieRatings.setMovie(movie);
        }

        final var ratingsResp = restTemplate.getForEntity("http://rating-service/v1/rating/"+id, Rating.class);
        if (HttpStatus.OK.equals(ratingsResp.getStatusCode()))
        {
            final var rating = ratingsResp.getBody();
            List<Rating> ratings = new ArrayList<>();
            System.out.println(rating);
            ratings.add(rating);
            movieRatings.setRatings(ratings);
        }

        System.out.println(movieRatings);
        return movieRatings;
    }

}
