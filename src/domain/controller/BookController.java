package domain.controller;

import domain.models.address.Address;
import domain.models.book.Book;
import domain.models.book.BookType;
import domain.models.book.bookEntities.Author;
import domain.models.book.bookEntities.BookEntity;
import domain.models.book.bookEntities.Measurement;
import domain.models.book.bookEntities.Publisher;
import storage.BookEntityStorage;
import storage.BookStorage;

import java.time.Year;
import java.util.ArrayList;

public class BookController {
    public static Author createAuthor (String email, String firstName, String lastName){
        Author newAuthor = new Author(email, firstName, lastName);
        BookEntityStorage.addEntity(newAuthor);
        return newAuthor;
    }

    public static Publisher createPublisher (String email, String title, Address address){
        Publisher newPublisher = new Publisher(email, title, address);
        BookEntityStorage.addEntity(newPublisher);
        return newPublisher;
    }

    public static Book createBook(String isbn, String title, BookType bookType,
                                  Year publicationsYear, String pages, Measurement measurement,
                                  ArrayList<BookEntity> bookEntities, double price){
        Book newBook = new Book(isbn, title, bookType, publicationsYear, pages, measurement, bookEntities, price);
        BookStorage.addBook(newBook);
        return newBook;
    }

    public static void removeBook(Book book){
        BookStorage.removeBook(book);
        book.removeBookFromEntities();
    }
}
