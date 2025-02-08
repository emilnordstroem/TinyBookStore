package domain.models.order;

import domain.models.book.Book;
import domain.models.cart.Cart;
import domain.models.cart.CartItem;
import domain.models.customer.Customer;
import domain.models.inventory.Stock;
import storage.StockStorage;

import java.time.LocalDate;
import java.util.HashMap;

public class Order implements OrderProcessable {
    private static long id = 100_001L;
    private final LocalDate placementDate;
    private Customer customer;
    private final HashMap<Book, Integer> orderList = new HashMap<>();
    private OrderStatus status;

    public Order(Customer customer, Cart cart) {
        id += 1;
        this.placementDate = LocalDate.now();
        setCustomer(customer);
        convertCartToOrderList(cart);
        updateOrder(OrderStatus.PLACED);
    }

    private void setCustomer(Customer customer) {
        this.customer = customer;
        customer.addOrder(this);
    }

    @Override
    public void convertCartToOrderList(Cart cart){
        for(CartItem item : cart.getItems()){
            Book book = item.getBook();
            int availableQuanitity = availableQuantity(book, item.getQuantity());
            if(availableQuanitity > 0){
                orderList.put(book, availableQuanitity);
            }
        }
    }

    @Override
    public int availableQuantity(Book book, int quantity){
        int orderableQuantity = 0;
        for(Stock stock : StockStorage.getStockArrayList()){
            if(stock.getBook().equals(book) && stock.isAvailable()){
                orderableQuantity = stock.getAvailableQuantity(quantity);
                if(orderableQuantity > 0){
                    stock.updateStock(orderableQuantity);
                }
                break;
            }
        }
        return orderableQuantity;
    }

    @Override
    public double getOrderPrice() {
        double orderPrice = 0;
        for(Book book : orderList.keySet()){
            orderPrice += (book.getprice() * orderList.get(book));
        }
        return orderPrice;
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

    public HashMap<Book, Integer> getOrderList() {
        return orderList;
    }

    public OrderStatus getStatus() {
        return status;
    }
}