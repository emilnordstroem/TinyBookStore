package domain.models.book;

import domain.models.book.bookEntities.*;
import domain.models.book.interfaces.Purchasable;
import domain.models.book.interfaces.Rateable;
import domain.models.book.interfaces.Searchable;
import domain.models.customer.Rating;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Book implements Rateable, Purchasable, Searchable<String> {
    private final String isbn;
    private final Description description;
    private final Measurement measurement;
    private final List<Author> authors;
    private final Publisher publisher;
    private final ArrayList<Rating> ratings = new ArrayList<>();
    private Boolean isRecommended;
    private double price;

    public Book(String isbn, Description description,
                Measurement measurement, List<Author> authors, Publisher publisher, double price) {
        this.isbn = isbn;
        this.description = description;
        this.measurement = measurement;
        this.authors = authors;
        this.publisher = publisher;
        this.isRecommended = false; // New books will not be placed as recommended
        this.price = price;
    }

    public void removeBookFromEntities(){
        publisher.removeBook(this);
        for(Author author : authors){
            author.removeBook(this);
        }
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

    public int isRecommended() {
        if(isRecommended){
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean matches(String search) {
        String lowerCaseSearch = search.toLowerCase();
        return description.getTitle().toLowerCase().contains(lowerCaseSearch)
                || authors.stream().anyMatch(a -> a.matches(lowerCaseSearch))
                || publisher.matches(lowerCaseSearch);
    }

    @Override
    public String toString(){
        return String.format("%s", description.getTitle());
    }

    public String getIsbn() {
        return isbn;
    }

    public Description getDescription() {
        return description;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public List<Author> getAuthors() {
        return new ArrayList<>(authors);
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public ArrayList<Rating> getRatings() {
        return new ArrayList<>(ratings);
    }

    public Boolean getRecommended() {
        return isRecommended;
    }

    public double getPrice() {
        return price;
    }

    public void setRecommended(Boolean recommended) {
        isRecommended = recommended;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
