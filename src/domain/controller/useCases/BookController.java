package domain.controller.useCases;

import domain.models.book.Book;
import domain.models.book.bookEntities.*;
import storage.toBeTerminated.BookEntityStorage;
import storage.toBeTerminated.BookStorage;

public class BookController {
    public static Author createAuthor (String email, String firstName, String lastName){
        Author newAuthor = new Author(email, firstName, lastName);
        BookEntityStorage.addEntity(newAuthor);
        return newAuthor;
    }

    public static Publisher createPublisher (String email, String title){
        Publisher newPublisher = new Publisher(email, title);
        BookEntityStorage.addEntity(newPublisher);
        return newPublisher;
    }

    public static Book createBook(String isbn, Description description, Measurement measurement,
                                  Author author, Publisher publisher, double price){
        Book newBook = new Book(isbn, description, measurement, author, publisher, price);
        BookStorage.addBook(newBook);
        return newBook;
    }

    public static void removeBook(Book book){
        BookStorage.removeBook(book);
        book.removeBookFromEntities();
    }
}
