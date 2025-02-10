package domain.models.book.bookEntities;

import domain.models.address.Address;
import domain.models.book.Book;
import domain.models.book.interfaces.Searchable;

import java.util.ArrayList;

public class Publisher extends BookEntity{
    private final String title;
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

    public String getTitle() {
        return title;
    }

    @Override
    public void addBook(Book book) {
        if(!books.contains(book)){
            books.add(book);
        }
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public ArrayList<Book> getBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public boolean matches(String search) {
        return title.toLowerCase().contains(search);
    }

    @Override
    public int compareTo(String searchTerm) {
        return title.compareTo(searchTerm);
    }
}
