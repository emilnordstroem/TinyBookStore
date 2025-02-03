package storage;

import domain.models.book.bookEntities.Author;
import domain.models.book.Book;
import domain.models.book.bookEntities.Entity;
import domain.models.book.bookEntities.Publisher;
import domain.models.customer.Customer;
import domain.models.customer.Rating;
import domain.models.order.Order;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Order> orders = new ArrayList<>();

    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<String> bookISBNs = new ArrayList<>();
    private static ArrayList<Entity> bookEntities = new ArrayList<>();

    private static ArrayList<Rating> ratings = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();

    public static ArrayList<Order> getOrders(){
        return new ArrayList<>(orders);
    }
    public static ArrayList<Book> getBooks(){
        return new ArrayList<>(books);
    }
    public static ArrayList<String> getBookISBNs(){
        return new ArrayList<>(bookISBNs);
    }
    public static ArrayList<Author> getAuthors(){
        ArrayList<Author> authors = new ArrayList<>();
        for(Entity entity : bookEntities){
            if(entity instanceof Author){
                authors.add((Author) entity);
            }
        }
        return authors;
    }
    public static ArrayList<Publisher> getPublishers(){
        ArrayList<Publisher> publishers = new ArrayList<>();
        for(Entity entity : bookEntities){
            if(entity instanceof Publisher){
                publishers.add((Publisher) entity);
            }
        }
        return publishers;
    }

    public static ArrayList<Rating> getRatings(){
        return new ArrayList<>(ratings);
    }
    public static ArrayList<Customer> getCustomers(){
        return new ArrayList<>(customers);
    }


    public static void addOrder(Order order){
        if(!orders.contains(order)){
            orders.add(order);
        }
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
    public static void addEntity(Entity entity){
        if(!bookEntities.contains(entity)){
            bookEntities.add(entity);
        }
    }
    public static void addRating(Rating rating){
        if(!ratings.contains(rating)){
            ratings.add(rating);
        }
    }
}