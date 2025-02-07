package domain.models.book.bookEntities;

import domain.models.book.Book;

import java.util.ArrayList;

public class Author extends BookEntity{
    private String firstName;
    private String lastName;

    public Author(String email, String firstName, String lastName) {
        super(email);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
