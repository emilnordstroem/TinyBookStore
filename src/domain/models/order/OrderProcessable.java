package domain.models.order;

import domain.models.book.Book;
import domain.models.cart.Cart;

public interface OrderProcessable {
    void convertCartToOrderList(Cart cart);
    int availableQuantity(Book book, int quantity);
    double getOrderPrice();
    void updateOrder(OrderStatus status);
    void cancelOrder();
}
