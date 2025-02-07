package domain.models.order;

import domain.models.cart.Cart;
import domain.models.customer.Customer;

import java.time.LocalDate;

public class Order implements OrderProcessable {
    private static long id = 100_001L;
    private LocalDate placementDate;
    private Customer customer;
    private Cart orderList;
    private OrderStatus status;

    public Order(Customer customer, Cart orderList) {
        id += 1;
        this.placementDate = LocalDate.now();
        setCustomer(customer);
        this.orderList = orderList;
        this.status = OrderStatus.PLACED;
    }

    private void setCustomer(Customer customer) {
        this.customer = customer;
        customer.addOrder(this);
    }

    @Override
    public double getOrderPrice() {
        return orderList.calculatePrice();
    }

    @Override
    public void updateOrder(OrderStatus status) {
        OrderStatus currentStatus = this.status;
        switch (status) {
            case CANCELLED:
                if (currentStatus.equals(OrderStatus.PLACED)) {
                    this.status = OrderStatus.CANCELLED;
                }
                break;
            case PACKED:
                if (currentStatus.equals(OrderStatus.PLACED)) {
                    this.status = OrderStatus.PACKED;
                }
                break;
            case INTRANSIT:
                if (currentStatus.equals(OrderStatus.PACKED)) {
                    this.status = OrderStatus.INTRANSIT;
                }
            case DELIVERED:
                if (currentStatus.equals(OrderStatus.INTRANSIT)) {
                    this.status = OrderStatus.DELIVERED;
                }
            case RETURNED:
                if (currentStatus.equals(OrderStatus.DELIVERED)) {
                    this.status = OrderStatus.RETURNED;
                }
                break;
        }
    }

    @Override
    public void cancelOrder() {
        updateOrder(OrderStatus.CANCELLED);
    }

    public static long getId() {
        return id;
    }

    public LocalDate getPlacementDate() {
        return placementDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Cart getOrderList() {
        return orderList;
    }

    public OrderStatus getStatus() {
        return status;
    }
}