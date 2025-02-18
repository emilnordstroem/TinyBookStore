package domain.models.customer;

import domain.models.address.Address;
import domain.models.book.Book;
import domain.models.cart.Cart;
import domain.models.order.Order;
import storage.toBeTerminated.RatingStorage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer extends User {
    private static Long customerId = 100_000L;
    private final String firstName;
    private final String lastName;
    private ContactInfo contacts;
    private final LocalDate dateOfBirth;
    private Cart cart;
    private final ArrayList<Order> orders = new ArrayList<>();
    private final ArrayList<Rating> bookRatings;
    private final ArrayList<Address> addresses = new ArrayList<>();

    public Customer(String firstName, String lastName, String email, String phoneNo, LocalDate dateOfBirth, Address address,
                    String password) {
        super(password);
        customerId += 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contacts = new ContactInfo(email, phoneNo);
        this.dateOfBirth = dateOfBirth;
        this.cart = new Cart();
        this.bookRatings = new ArrayList<>();
        addAddress(address);
    }

    public void addItemToCart(Book book, int quantity){
        this.cart.addItem(book, quantity);
    }

    public Cart getCart() {
        return cart;
    }

    public ArrayList<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public void addOrder(Order order){
        if(!orders.contains(order)){
            orders.add(order);
        }
    }

    public ArrayList<Rating> getBookRatings() {
        return bookRatings;
    }

    public void createRating(Book book, double ratingScore, String comment){
        Rating newRating = new Rating(this, book, ratingScore, comment);
        RatingStorage.addRating(newRating);
        addRating(newRating);
    }

    private void addRating(Rating rating){
        if(!bookRatings.contains(rating)){
            bookRatings.add(rating);
        }
    }

    public void removeRating(Rating rating){
        bookRatings.remove(rating);
    }

    public void addAddress(Address address) {
        if (!addresses.contains(address)
                && addresses.size() < 5) {
            addresses.add(address);
        }
    }

    private void removeAddress(Address address){
        addresses.remove(address);
    }
}
