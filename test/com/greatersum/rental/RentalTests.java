package com.greatersum.rental;

import org.approvaltests.Approvals;
import org.junit.Test;

import java.util.Arrays;

import static com.greatersum.rental.MovieCategory.*;

public class RentalTests {
    private RentalInfo info = new RentalInfo();
    private final Movie F001 = new Movie("F001", "Ran", REGULAR);
    private final Movie F002 = new Movie("F002", "Trois Couleurs: Bleu", REGULAR);
    private final Movie F003 = new Movie("F003", "Cars 2", CHILDRENS);
    private final Movie F004 = new Movie("F004", "Latest Hit Release", NEW);

    @Test
    public void RentRegularMovieFor1Day() {
        Customer customer = new Customer("martin", Arrays.asList(new MovieRental(F001, 1)));
        String actualResult = info.statement(customer);
        Approvals.verify(actualResult);
    }

    @Test
    public void RentRegularMovieFor2Day() {
        Customer customer = new Customer("martin", Arrays.asList(new MovieRental(F001, 2)));
        String actualResult = info.statement(customer);
        Approvals.verify(actualResult);
    }

    @Test
    public void RentRegularMovieFor7Day() {
        Customer customer = new Customer("martin", Arrays.asList(new MovieRental(F001, 7)));
        String actualResult = info.statement(customer);
        Approvals.verify(actualResult);
    }

    @Test
    public void RentChildrensMovieFor1Day() {
        Customer customer = new Customer("martin", Arrays.asList(new MovieRental(F003, 1)));
        String actualResult = info.statement(customer);
        Approvals.verify(actualResult);
    }

    @Test
    public void RentChildrensMovieFor2Day() {
        Customer customer = new Customer("martin", Arrays.asList(new MovieRental(F003, 2)));
        String actualResult = info.statement(customer);
        Approvals.verify(actualResult);
    }

    @Test
    public void RentChildrensMovieFor7Day() {
        Customer customer = new Customer("martin", Arrays.asList(new MovieRental(F003, 7)));
        String actualResult = info.statement(customer);
        Approvals.verify(actualResult);
    }

    @Test
    public void RentNewMovieFor1Day() {
        Customer customer = new Customer("martin", Arrays.asList(new MovieRental(F004, 1)));
        String actualResult = info.statement(customer);
        Approvals.verify(actualResult);
    }

    @Test
    public void RentNewMovieFor2Day() {
        Customer customer = new Customer("martin", Arrays.asList(new MovieRental(F004, 2)));
        String actualResult = info.statement(customer);
        Approvals.verify(actualResult);
    }

    @Test
    public void RentNewMovieFor7Day() {
        Customer customer = new Customer("martin", Arrays.asList(new MovieRental(F004, 7)));
        String actualResult = info.statement(customer);
        Approvals.verify(actualResult);
    }
    @Test
    public void Rent2Movies2Days() {
        Customer customer = new Customer("martin", Arrays.asList(
                new MovieRental(F001, 2),
                new MovieRental(F002, 2)));
        String actualResult = info.statement(customer);
        Approvals.verify(actualResult);
    }

    @Test
    public void Rent3Movies3Days() {
        Customer customer = new Customer("martin", Arrays.asList(
                new MovieRental(F001, 3),
                new MovieRental(F002, 3),
                new MovieRental(F003, 3)));
        String actualResult = info.statement(customer);
        Approvals.verify(actualResult);
    }

    @Test
    public void Rent4Movies4Days() {
        Customer customer = new Customer("martin", Arrays.asList(
                new MovieRental(F001, 4),
                new MovieRental(F002, 4),
                new MovieRental(F003, 4),
                new MovieRental(F004, 4)));
        String actualResult = info.statement(customer);
        Approvals.verify(actualResult);
    }
}
