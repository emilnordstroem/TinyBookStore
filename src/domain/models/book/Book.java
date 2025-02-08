package domain.models.book;

import domain.models.book.bookEntities.Author;
import domain.models.book.bookEntities.BookEntity;
import domain.models.book.bookEntities.Measurement;
import domain.models.book.bookEntities.Publisher;
import domain.models.book.interfaces.Purchasable;
import domain.models.book.interfaces.Rateable;
import domain.models.book.interfaces.Searchable;
import domain.models.customer.Rating;

import java.time.Year;
import java.util.ArrayList;

public class Book implements Rateable, Purchasable, Searchable {
    private String isbn;
    private String title;
    private BookType bookType;
    private Year publicationsYear;
    private String pages;
    private Measurement measurement;
    private ArrayList<BookEntity> bookEntities = new ArrayList<>();
    private ArrayList<Rating> ratings = new ArrayList<>();
    private Boolean isRecommended;
    private double price;

    public Book(String isbn, String title, BookType bookType,
                Year publicationsYear, String pages, Measurement measurement,
                ArrayList<BookEntity> bookEntities, double price) {
        this.isbn = isbn;
        this.title = title;
        this.bookType = bookType;
        this.publicationsYear = publicationsYear;
        this.pages = pages;
        this.measurement = measurement;
        addBookEntity(bookEntities);
        this.isRecommended = false; // New books will not be placed as recommended
        this.price = price;
    }

    public void addBookEntity(ArrayList<BookEntity> entities) {
        for(BookEntity entity : entities){
            bookEntities.add(entity);
            if(entity instanceof Publisher){
                ((Publisher) entity).addBook(this);
            } else if (entity instanceof Author){
                ((Author) entity).addBook(this);
            }
        }
    }

    public void removeBookFromEntities(){
        for(BookEntity entity : bookEntities){
            if(entity instanceof Author){
                ((Author) entity).removeBook(this);
            } else if (entity instanceof Publisher){
                ((Publisher) entity).removeBook(this);
            }
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

    public ArrayList<BookEntity> getBookEntities() {
        return new ArrayList<>(bookEntities);
    }
}
