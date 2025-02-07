package domain.models.book.bookEntities;

import domain.models.address.Address;
import domain.models.book.Book;

import java.util.ArrayList;

public class Publisher extends BookEntity{
    private String title;
    private Address address;

    public Publisher(String email, String title, Address address) {
        super(email);
        this.title = title;
        this.address = address;
    }

    public void changeAddress(Address address){
        if(!this.address.equals(address)){
            this.address = address;
        }
    }

    @Override
    void addBook(Book book) {
        if(!books.contains(book)){
            books.add(book);
        }
    }

    @Override
    void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    ArrayList<Book> getBooks() {
        return new ArrayList<>(books);
    }
}
