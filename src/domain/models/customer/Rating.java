package domain.models.customer;

import domain.models.book.Book;

public class Rating {
    private static Long id = 100_000_000L;
    private Customer customer;
    private Book book;
    private double rating;
    private String comment;

    public Rating(Customer customer, Book book, double rating, String comment) {
        this.customer = customer;
        this.book = book;
        this.rating = rating;
        this.comment = comment;
    }

    public static Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Book getBook() {
        return book;
    }

    public double getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
