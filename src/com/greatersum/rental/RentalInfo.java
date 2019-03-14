package com.greatersum.rental;

import java.math.BigDecimal;
import java.util.List;

public class RentalInfo {

    public String statement(Customer customer) {
        BigDecimal totalAmount = calculateTotalPrice(customer.getRentals());
        int frequentRenterPoints = calculateFrequentRentalPoints(customer.getRentals());

        return createStatement(customer, totalAmount, frequentRenterPoints);
    }

    private String createStatement(Customer customer, BigDecimal totalAmount, int frequentRenterPoints) {
        StringBuilder statement = new StringBuilder("Rental Record for ").append(customer.getName()).append("\n");
        for (MovieRental r : customer.getRentals()) {
            Movie movie = r.getMovie();
            BigDecimal thisAmount = movie.calculateMoviePrice(r.getDays());
            statement.append("\t").append(movie.getTitle()).append("\t").append(thisAmount).append("\n");
        }
        statement.append("Amount owed is ").append(totalAmount).append("\n");
        statement.append("You earned ").append(frequentRenterPoints).append(" frequent renter points\n");
        return statement.toString();
    }

    private int calculateFrequentRentalPoints(List<MovieRental> rentals) {
        int points = 0;
        for (MovieRental r : rentals) {
            Movie movie = r.getMovie();
            points += movie.calculateFrequentRentalPoints(r.getDays());
        }
        return points;
    }

    private BigDecimal calculateTotalPrice(List<MovieRental> rentals) {
        BigDecimal total = BigDecimal.ZERO;
        for (MovieRental r : rentals) {
            Movie movie = r.getMovie();
            total = total.add(movie.calculateMoviePrice(r.getDays()));
        }
        return total;
    }

}
