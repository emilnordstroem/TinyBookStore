package domain.models.cart;

import domain.models.book.Book;

public class CartItem {
    private Book book;
    private int quantity;
    private double price;

    public CartItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
        setPrice(book.getprice());
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
