package storage.toBeTerminated;


import domain.models.customer.Customer;

import java.util.ArrayList;

public class CustomerStorage {
    private final static ArrayList<Customer> customerArrayList = new ArrayList<>();

    public static void addCustomer(Customer customer){
        if(!customerArrayList.contains(customer)){
            customerArrayList.add(customer);
        }
    }

    public static ArrayList<Customer> getCustomerArrayList(){
        return new ArrayList<>(customerArrayList);
    }
}
