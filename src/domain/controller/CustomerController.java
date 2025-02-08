package domain.controller;

import domain.models.address.Address;
import domain.models.customer.Customer;
import storage.CustomerStorage;

import java.time.LocalDate;

public class CustomerController {

    public static Customer createCustomer(String firstName, String lastName, LocalDate dateOfBirth,
                                          String email, String mobileNo, Address address,
                                          String password){
        Customer newCustomer = new Customer(firstName, lastName, dateOfBirth, email, mobileNo, address, password);
        CustomerStorage.addCustomer(newCustomer);
        return newCustomer;
    }

    // Adding address directly in the Customer class
    // Creating rating directly in the Customer class
    // Adding items to cart directly in the Customer class
}
