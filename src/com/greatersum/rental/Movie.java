package com.greatersum.rental;

import java.math.BigDecimal;

public class Movie {
    private final String id;
    private final String title;
    private final MovieCategory movieCategory;

    public Movie(String id, String title, MovieCategory movieCategory) {
        this.id = id;
        this.title = title;
        this.movieCategory = movieCategory;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public MovieCategory getMovieCategory() {
        return movieCategory;
    }

    public int calculateFrequentRentalPoints(int days) {
        return movieCategory.bonusPoints(days);
    }

    public BigDecimal calculateMoviePrice(int days) {
        return movieCategory.rentalPrice(days);
    }
}
