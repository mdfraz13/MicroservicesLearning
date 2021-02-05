package com.learning.ratingservice.beans;

public class Rating {

    private String id;
    private int ratingValue;

    public Rating(String id, int ratingValue) {
        this.id = id;
        this.ratingValue = ratingValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }
}
