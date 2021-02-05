package com.learning.ratingservice.controller;

import com.learning.ratingservice.beans.Rating;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/")
public class RatingController {

    @PostMapping("/rating")
    public Rating createMovie(@RequestBody Rating rating) {
        return new Rating("12", 10);
    }

    @GetMapping("/rating/{id}")
    public Rating getMovie(@PathVariable("id") String id) {
        return new Rating(id, 10);
    }
}
