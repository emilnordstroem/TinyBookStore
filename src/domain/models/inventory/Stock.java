package domain.models.inventory;

import domain.models.book.Book;

public class Stock implements StockManageable{
    private int quantity;
    private Book book;
    private boolean isAvailable;

    public Stock(int quantity, Book book) {
        this.quantity = updateStock(quantity);
        this.book = book;
        this.isAvailable = updateAvailability();
    }

    @Override
    public int updateStock(int quantity) {
        this.quantity += quantity;
        updateAvailability();
    }

    @Override
    public boolean updateAvailability() {
        isAvailable = quantity > 0;
    }
}
