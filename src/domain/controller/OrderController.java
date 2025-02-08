package domain.controller;

import domain.models.customer.Customer;
import domain.models.order.Order;
import storage.OrderStorage;

public class OrderController {
    public static void createOrder(Customer customer){
        if(!customer.getCart().getItems().isEmpty()){
            Order newOrder = new Order(customer, customer.getCart());
            OrderStorage.addOrder(newOrder);
        }
    }
}
