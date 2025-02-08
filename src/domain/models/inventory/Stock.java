package domain.models.inventory;

import domain.models.book.Book;
import storage.StockStorage;

public class Stock implements StockManageable{
    private int quantity;
    private final Book book;
    private boolean isAvailable;

    public Stock(int quantity, Book book) {
        updateStock(quantity);
        this.book = book;
        updateAvailability();
    }

    @Override
    public void updateStock(int quantity) {
        this.quantity += quantity;
        updateAvailability();
        StockStorage.updateStockArrayList(this);
    }

    @Override
    public void updateAvailability() {
        isAvailable = quantity > 0;
    }

    public int getAvailableQuantity(int change){
        return Math.max(0, quantity - change);
    }

    public int getQuantity() {
        return quantity;
    }

    public Book getBook() {
        return book;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
