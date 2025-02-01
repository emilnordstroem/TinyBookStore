package domain.models.customer;

import domain.models.book.Book;
import storage.Storage;

import java.util.ArrayList;
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
        if(idAreadyUsed(id)){
            generateID();
        }
        return id;
    }

    private boolean idAreadyUsed(String id){
        ArrayList<Rating> ratings = Storage.getRatings();
        for(Rating rating : ratings){
            if(rating.getId().equals(id)){
                return true;
            }
        }
        return false;
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
