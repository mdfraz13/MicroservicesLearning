package com.example.movieratingwithhystrix.controller;

import com.example.movieratingwithhystrix.beans.MovieRatings;
import com.example.movieratingwithhystrix.service.MovieRatingService;
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

    @GetMapping("/hystrix/movie-rating/{id}")
    public MovieRatings getMovieRatings(@PathVariable("id") String id) {
        return movieRatingService.getWithHystrixMovieRatings(id);
    }
}
