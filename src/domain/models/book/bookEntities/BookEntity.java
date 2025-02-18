package domain.models.book.bookEntities;

import domain.models.book.Book;
import domain.models.book.interfaces.Searchable;

import java.util.ArrayList;

public abstract class BookEntity implements Searchable<String>{
    protected static long idCounter = 1_000_001;
    protected final long id;
    protected String email;
    protected ArrayList<Book> books;

    public BookEntity(String email) {
        id = idCounter++;
        this.email = email;
        this.books = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    abstract void addBook(Book book);
    abstract void removeBook(Book book);
    abstract ArrayList<Book> getBooks();
}
