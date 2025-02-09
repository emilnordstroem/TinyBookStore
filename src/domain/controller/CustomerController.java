package domain.controller;

import domain.models.address.Address;
import domain.models.book.Book;
import domain.models.customer.Customer;
import domain.models.order.Order;
import storage.CustomerStorage;

import java.time.LocalDate;

public class CustomerController {

    public static Customer createCustomer(String firstName, String lastName, LocalDate dateOfBirth,
                                          String email, String mobileNo, Address address,
                                          String password){
        Customer newCustomer = new Customer(firstName, lastName, email, mobileNo, dateOfBirth, address, password);
        CustomerStorage.addCustomer(newCustomer);
        return newCustomer;
    }

    public static void createCustomerRating(Customer customer, Book book,
                                              double ratingScore, String comment){
        boolean bookHasBeenOrdered = false;
        for(Order order : customer.getOrders()){
            if(order.getOrderList().containsKey(book)){
                bookHasBeenOrdered = true;
                break;
            }
        }
        if(bookHasBeenOrdered){
            customer.createRating(book, ratingScore, comment);
        }
    }

    // Adding address directly in the Customer class
    // Adding items to cart directly in the Customer class
}
