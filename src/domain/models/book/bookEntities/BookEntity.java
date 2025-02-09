package domain.models.book.bookEntities;

import domain.models.book.Book;
import domain.models.book.interfaces.Searchable;

import java.util.ArrayList;

public abstract class BookEntity implements Searchable<String>{
    protected static long id = 1_000_001;
    protected String email;
    protected ArrayList<Book> books;

    public BookEntity(String email) {
        id += 1;
        this.email = email;
        this.books = new ArrayList<>();
    }

    abstract void addBook(Book book);
    abstract void removeBook(Book book);
    abstract ArrayList<Book> getBooks();
}
