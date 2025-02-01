package domain.models.stock;

import domain.models.book.Book;
import domain.models.order.OrderList;

import java.util.ArrayList;

public class Stock {
    private Book book;
    private StockStatus status;
    private int quantity;
    private ArrayList<OrderList> orderLists;

    public Stock(Book book, StockStatus status, int quantity) {
        this.book = book;
        this.status = calculateStockStatus();
        this.quantity = quantity;
    }

    private StockStatus calculateStockStatus() {
        if(quantity > 0 && quantity <= 5){
            return StockStatus.LOW;
        } else if (quantity > 5) {
            return StockStatus.HIGH;
        } else {
            return StockStatus.UNAVAILABLE;
        }
    }

    public Book getBook() {
        return book;
    }

    public StockStatus getStatus() {
        return status;
    }

    public int getQuantity() {
        return quantity;
    }

    public ArrayList<OrderList> getOrderLists() {
        return orderLists;
    }
}
