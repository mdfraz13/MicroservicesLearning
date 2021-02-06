package com.example.movieratingwithhystrix.service;

import com.example.movieratingwithhystrix.beans.Movie;
import com.example.movieratingwithhystrix.beans.MovieRatings;
import com.example.movieratingwithhystrix.beans.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @Autowired
    private MovieService movieService;

    @Autowired
    private RatingService ratingService;

    @HystrixCommand(fallbackMethod = "getMovieRatingsFallback")
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

    public MovieRatings getWithHystrixMovieRatings(String id) {
        final var movieRatings = new MovieRatings();

        final var movie = movieService.getMovie(id);
        final var ratings = ratingService.getRatings(id);

        movieRatings.setMovie(movie);
        movieRatings.setRatings(ratings);

        System.out.println(movieRatings);
        return movieRatings;
    }

    public MovieRatings getMovieRatingsFallback(String id) {
        return new MovieRatings("000", new Movie("00", "Dummy Movie"), new ArrayList<>());
    }

}
