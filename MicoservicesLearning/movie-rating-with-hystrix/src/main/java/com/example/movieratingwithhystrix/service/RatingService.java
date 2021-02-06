package com.example.movieratingwithhystrix.service;

import com.example.movieratingwithhystrix.beans.Movie;
import com.example.movieratingwithhystrix.beans.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getRatingsFallback", groupKey="ProductServiceGroup",commandKey = "test")
    public List<Rating> getRatings(String id) {
        final var ratingsResp = restTemplate.getForEntity("http://rating-service/v1/rating/"+id, Rating.class);
        final var rating = ratingsResp.getBody();
        List<Rating> ratings = new ArrayList<>();
        ratings.add(rating);
        return ratings;
    }

    public List<Rating> getRatingsFallback(String id) {
        System.out.println("fallback to default rating...");
        return new ArrayList<>();
    }
}
