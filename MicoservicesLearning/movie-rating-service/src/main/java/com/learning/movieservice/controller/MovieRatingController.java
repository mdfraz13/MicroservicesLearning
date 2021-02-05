package com.learning.movieservice.controller;

import com.learning.movieservice.beans.MovieRatings;
import com.learning.movieservice.service.MovieRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class MovieRatingController {

    @Autowired
    private MovieRatingService movieRatingService;

    @PostMapping("/movie-rating")
    public MovieRatings createMovie(@RequestBody MovieRatings movie) {
        return null;
    }

    @GetMapping("/movie-rating/{id}")
    public MovieRatings getMovie(@PathVariable("id") String id) {
        return movieRatingService.getMovieRatings(id);
    }
}
