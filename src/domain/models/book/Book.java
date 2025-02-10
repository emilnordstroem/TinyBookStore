package domain.models.book;

import domain.models.book.bookEntities.*;
import domain.models.book.interfaces.Purchasable;
import domain.models.book.interfaces.Rateable;
import domain.models.book.interfaces.Searchable;
import domain.models.customer.Rating;
import java.util.ArrayList;
import java.util.Locale;

public class Book implements Rateable, Purchasable, Searchable<String> {
    private String isbn;
    private Description description;
    private Measurement measurement;
    private final Author author;
    private final Publisher publisher;
    private final ArrayList<Rating> ratings = new ArrayList<>();
    private Boolean isRecommended;
    private double price;

    public Book(String isbn, Description description,
                Measurement measurement, Author author, Publisher publisher, double price) {
        this.isbn = isbn;
        this.description = description;
        this.measurement = measurement;
        this.author = author;
        this.publisher = publisher;
        this.isRecommended = false; // New books will not be placed as recommended
        this.price = price;
    }


    public void removeBookFromEntities(){
        author.removeBook(this);
        publisher.removeBook(this);
    }

    @Override
    public double getprice() {
        return price;
    }

    @Override
    public void addRating(Rating rating) {
        if(!ratings.contains(rating)){
            ratings.add(rating);
        }
    }

    @Override
    public Rating getRating(Rating rating) {
        for(Rating bookRating : ratings){
            if(bookRating.equals(rating)){
                return rating;
            }
        }
        return null;
    }

    @Override
    public double getAverageRating() {
        double totalRating = 0;
        int counter = 0;
        for(Rating rating : ratings){
            totalRating += rating.getRating();
            counter++;
        }
        double average = totalRating / counter;
        updateRecommendation(average);
        return average;
    }

    @Override
    public void updateRecommendation(double averageRating) {
        if(averageRating > 8.5){
            isRecommended = true;
        }
    }

    public Author getAuthor() {
        return author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    @Override
    public boolean matches(String search) {
        return description.getTitle().toLowerCase().contains(search.toLowerCase())
                || author.matches(search.toLowerCase())
                || publisher.matches(search.toLowerCase());
    }

    @Override
    public int compareTo(String searchTerm) {
        return description.getTitle().compareToIgnoreCase(searchTerm);
    }

    public Description getDescription() {
        return description;
    }

    @Override
    public String toString(){
        return String.format("%s", description.getTitle());
    }
}
