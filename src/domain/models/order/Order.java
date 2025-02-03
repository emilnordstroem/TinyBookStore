package domain.models.order;

import domain.models.customer.Address;
import domain.models.customer.Customer;

import java.time.LocalDate;

public class Order {
    private static int id = 100_001;
    private OrderList orderedBooks;
    private LocalDate placementDate;
    private Customer customer;
    private Address address;
    private double price;

    public Order(OrderList orderedBooks, LocalDate placementDate,
                 Customer customer, Address address) {
        id += 1;
        this.orderedBooks = orderedBooks;
        this.placementDate = placementDate;
        this.customer = customer;
        this.address = address;
        this.price = calculatePrice();
    }

    public double calculatePrice(){
        return 0;
    }

    public OrderList getOrderedBooks() {
        return orderedBooks;
    }

    public LocalDate getPlacementDate() {
        return placementDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Address getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }
}
