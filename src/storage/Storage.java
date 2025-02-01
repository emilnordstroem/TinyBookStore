package storage;

import domain.models.book.bookEntities.Author;
import domain.models.book.Book;
import domain.models.book.bookEntities.Publisher;
import domain.models.customer.Customer;
import domain.models.customer.Rating;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<String> bookISBNs = new ArrayList<>();
    private static ArrayList<Author> authors = new ArrayList<>();
    private static ArrayList<Publisher> publishers = new ArrayList<>();

    private static ArrayList<Rating> ratings = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();

    public static ArrayList<Book> getBooks(){
        return new ArrayList<>(books);
    }
    public static ArrayList<String> getBookISBNs(){
        return new ArrayList<>(bookISBNs);
    }
    public static ArrayList<Author> getAuthors(){
        return new ArrayList<>(authors);
    }
    public static ArrayList<Publisher> getPublishers(){
        return new ArrayList<>(publishers);
    }

    public static ArrayList<Rating> getRatings(){
        return new ArrayList<>(ratings);
    }
    public static ArrayList<Customer> getCustomers(){
        return new ArrayList<>(customers);
    }


    public static void addBook(Book book){
        if(!books.contains(book)){
            books.add(book);
        }
    }
    public static void addBookISBN(String id){
        if(!bookISBNs.contains(id)){
            bookISBNs.add(id);
        }
    }
    public static void addAuthor(Author author){
        if(!authors.contains(author)){
            authors.add(author);
        }
    }
    public static void addPublisher(Publisher publisher){
        if(!publishers.contains(publisher)){
            publishers.add(publisher);
        }
    }
    public static void addRating(Rating rating){
        if(!ratings.contains(rating)){
            ratings.add(rating);
        }
    }
}