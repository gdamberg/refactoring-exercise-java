package com.greatersum.rental;

import java.math.BigDecimal;
import java.util.HashMap;

public class RentalInfo {

    public String statement(Customer customer) {
        HashMap<String, Movie> movies = new HashMap<>();
        movies.put("F001", new Movie("Ran", "regular"));
        movies.put("F002", new Movie("Trois Couleurs: Bleu", "regular"));
        movies.put("F003", new Movie("Cars 2", "childrens"));
        movies.put("F004", new Movie("Latest Hit Release", "new"));

        BigDecimal totalAmount = BigDecimal.valueOf(0);
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + customer.getName() + "\n";

        for (MovieRental r : customer.getRentals()) {
            Movie movie = movies.get(r.getMovieId());

            BigDecimal thisAmount = calculateMoviePrice(r, movie);
            frequentRenterPoints += calculateFrequentRentalPoints(r, movie);

            //print figures for this rental
            result += "\t" + movie.getTitle() + "\t" + thisAmount + "\n";
            totalAmount = totalAmount.add(thisAmount);
        }
        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";

        return result;
    }

    private int calculateFrequentRentalPoints(MovieRental r, Movie movie) {
        int points = 1;
        // add bonus for a two day new release rental
        if (movie.getCode().equals("new") && r.getDays() > 2) points++;
        return points;
    }

    private BigDecimal calculateMoviePrice(MovieRental r, Movie movie) {
        BigDecimal price = BigDecimal.valueOf(0);

        // determine amount for each movie
        switch (movie.getCode()) {
            case "regular":
                price = BigDecimal.valueOf(2);
                if (r.getDays() > 2) {
                    price = BigDecimal.valueOf((r.getDays() - 2) * 1.5).add(price);
                }
                break;
            case "new":
                price = BigDecimal.valueOf(r.getDays() * 3);
                break;
            case "childrens":
                price = BigDecimal.valueOf(1.5);
                if (r.getDays() > 3) {
                    price = BigDecimal.valueOf((r.getDays() - 3) * 1.5).add(price);
                }
                break;
        }
        return price;
    }
}
