package domain.models.order;

public interface OrderProcessable {
    double getOrderPrice();
    void updateOrder(OrderStatus status);
    void cancelOrder();
}
