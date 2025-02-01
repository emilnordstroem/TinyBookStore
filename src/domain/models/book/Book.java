package domain.models.book;

import domain.models.book.bookEntities.Author;
import domain.models.book.bookEntities.Publisher;
import domain.models.customer.Rating;

import java.time.LocalDate;
import java.util.ArrayList;

public class Book {
    private String isbn;
    private String title;
    private Genre genre;
    private ArrayList<Author> authors;
    private Publisher publisher;
    private LocalDate publishmentDate;
    private double price;
    private ArrayList<Rating> ratings;
    private RatingLevel ratingLevel;

    public Book(String isbn, String title, Genre genre, ArrayList<Author> authors,
                Publisher publisher, LocalDate publishmentDate, double price) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.authors = authors;
        this.publisher = publisher;
        this.publishmentDate = publishmentDate;
        this.price = price;
        this.ratings = new ArrayList<>();
        this.ratingLevel = null;
    }

    public void addRating(Rating rating){
        if(!ratings.contains(rating)){
            ratings.add(rating);
            evaluteBookRating();
        }
    }

    private void evaluteBookRating(){
        double ratingLevel = 0;
        int index = 0;
        while(index < ratings.size()){
            ratingLevel += ratings.get(index).getRating();
            index++;
        }
        ratingLevelTerminator(ratingLevel / (index + 1));
    }

    private void ratingLevelTerminator(double average){
        if(average < 3.0){
            ratingLevel = RatingLevel.LOW;
        } else if (average > 3.0 && average <= 7.0) {
            ratingLevel = RatingLevel.MID;
        } else if (average > 7.0){
            ratingLevel = RatingLevel.HIGH;
        }
    }

    public void removeRating(Rating rating){
        ratings.remove(rating);
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public ArrayList<Author> getAuthors() {
        return new ArrayList<>(authors);
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public LocalDate getPublishmentDate() {
        return publishmentDate;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<Rating> getRatings() {
        return new ArrayList<>(ratings);
    }
}
