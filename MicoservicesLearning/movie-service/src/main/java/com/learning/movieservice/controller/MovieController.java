package com.learning.movieservice.controller;

import com.learning.movieservice.beans.Movie;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class MovieController {

    @PostMapping("/movie")
    public Movie createMovie(@RequestBody Movie movie) {
        return new Movie("12", "Avengers Endgame");
    }

    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable("id") String id) {
        return new Movie(id, "Avengers Endgame");
    }
}
