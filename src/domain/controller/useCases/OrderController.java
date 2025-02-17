package domain.controller.useCases;

import domain.models.customer.Customer;
import domain.models.order.Order;
import storage.toBeTerminated.OrderStorage;

public class OrderController {
    public static Order createOrder(Customer customer){
        assert customer != null;
        assert customer.getCart() != null;
        assert customer.getCart().getItems() != null;

        Order newOrder = new Order(customer, customer.getCart());
        OrderStorage.addOrder(newOrder);
        return newOrder;
    }
}
