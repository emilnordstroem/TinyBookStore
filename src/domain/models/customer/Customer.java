package domain.models.customer;

import domain.models.address.Address;
import domain.models.book.Book;
import domain.models.cart.Cart;
import domain.models.order.Order;
import storage.RatingStorage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer extends User {
    private static Long id = 100_000L;
    private String firstName;
    private String lastName;
    private final LocalDate dateOfBirth;
    private String mobileNo;
    private Cart cart = new Cart();
    private final ArrayList<Order> orders = new ArrayList<>();
    private final ArrayList<Rating> bookRatings;
    private final ArrayList<Address> addresses = new ArrayList<>();

    public Customer(String firstName, String lastName, LocalDate dateOfBirth,
                    String email, String mobileNo, Address address,
                    String password) {
        super(email, password);
        id += 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.mobileNo = mobileNo;
        this.bookRatings = new ArrayList<>();
        addAddress(address);
    }

    public void addAddress(Address address) {
        if (!addresses.contains(address)
                && addresses.size() < 5) {
            addresses.add(address);
        }
    }

    public void addOrder(Order order){
        if(!orders.contains(order)){
            orders.add(order);
        }
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

    private void removeRating(Rating rating){
        bookRatings.remove(rating);
    }

    private void removeAddress(Address address){
        addresses.remove(address);
    }

    public void addItemToCart(Book book, int quantity){
        this.cart.addItem(book, quantity);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public Cart getCart() {
        return cart;
    }

    public void defaultCart(){
        this.cart = new Cart();
    }

    public ArrayList<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public ArrayList<Rating> getBookRatings() {
        return new ArrayList<>(bookRatings);
    }

    public ArrayList<Address> getAddresses() {
        return new ArrayList<>(addresses);
    }
}
