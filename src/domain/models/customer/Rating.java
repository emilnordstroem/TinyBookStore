package domain.models.customer;

import domain.models.book.Book;
import storage.IdentificationStorage;

import java.util.Random;

public class Rating {
    private String id;
    private Book book;
    private double rating;
    private Customer customer;

    public Rating(Book book, double rating, Customer customer) {
        this.id = generateID();
        this.book = book;
        this.rating = rating;
        this.customer = customer;
    }

    private String generateID(){
        String id = String.valueOf(new Random().nextInt(100_000_000,888_888_888));
        if(IdentificationStorage.getRatingIDs().contains(id)){
            generateID();
        }
        IdentificationStorage.addRatingID(id);
        return id;
    }

    private void addRatingToBook(){
        book.addRating(this);
    }

    public String getId() {
        return id;
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
