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

    public String getFullName(){
        return String.format("%s %s",
                firstName,
                lastName);
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
        return firstName.toLowerCase().contains(search)
                || lastName.toLowerCase().contains(search)
                || getFullName().toLowerCase().contains(search);
    }

    @Override
    public int compareTo(String searchTerm) {
        return lastName.compareTo(searchTerm);
    }
}
