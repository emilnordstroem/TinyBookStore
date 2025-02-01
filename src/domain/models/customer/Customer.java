package domain.models.customer;

import domain.models.book.Book;
import domain.models.order.Order;
import storage.Storage;

import java.util.ArrayList;
import java.util.Random;

public class Customer {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private ArrayList<Order> orders;
    private ArrayList<Address> addresses = new ArrayList<>();
    private ArrayList<Rating> bookRatings;

    public Customer(String firstName, String lastName, String phoneNo, String email, Address address) {
        this.id = generateID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.orders = new ArrayList<>();
        this.addresses.add(address);
        this.bookRatings = new ArrayList<>();
    }

    private long generateID(){
        long id = new Random().nextLong(100_000_000,888_888_888);
        if(idAreadyUsed(id)){
            generateID();
        }
        return id;
    }

    private boolean idAreadyUsed(long id){
        ArrayList<Customer> customers = Storage.getCustomers();
        for(Customer customer : customers){
            if(customer.getId() == id){
                return true;
            }
        }
        return false;
    }

    public void createRating(Book book, double rating){
        Rating newRating = new Rating(book, rating, this);
        bookRatings.add(newRating);
    }

    public void removeRating(Rating ratingToRemove){
        Book book = ratingToRemove.getBook();
        bookRatings.remove(ratingToRemove);
        book.removeRating(ratingToRemove);
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public ArrayList<Rating> getBookRatings() {
        return bookRatings;
    }
}
