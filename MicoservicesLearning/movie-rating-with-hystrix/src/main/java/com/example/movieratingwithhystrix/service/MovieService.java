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
public class MovieService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getMovieFallback")
    public Movie getMovie(String id) {
        final var movieResp = restTemplate.getForEntity("http://movie-service/v1/movie/"+id, Movie.class);
        if (HttpStatus.OK.equals(movieResp.getStatusCode())) {
            System.out.println("recieved success response from Movie service ..");
            final var movie = movieResp.getBody();
            return movie;
        }
        else {
            System.out.println("failure response from movie");
        }

        return null;
    }

    public Movie getMovieFallback(String id) {
        System.out.println("fallback to default movie...");
        return new Movie("00", "Dummy Movie");
    }
}
