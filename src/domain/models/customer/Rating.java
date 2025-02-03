package domain.models.customer;

import domain.models.book.Book;
import storage.Storage;

import java.util.ArrayList;
import java.util.Random;

public class Rating {
    private static long id = 100_000_001;
    private Book book;
    private double rating;
    private Customer customer;

    public Rating(Book book, double rating, Customer customer) {
        id += 1;
        this.book = book;
        this.rating = rating;
        this.customer = customer;
    }

    private void addRatingToBook(){
        book.addRating(this);
    }

    public Book getBook() {
        return book;
    }
    public double getRating() {
        return rating;
    }
    public Customer getCustomer() {
        return customer;
    }
}
