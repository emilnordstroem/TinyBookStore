package storage;

import domain.models.book.entity.Author;
import domain.models.book.Book;
import domain.models.book.entity.Publisher;

import java.util.ArrayList;

public class BookAndEntityStorage {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Author> authors = new ArrayList<>();
    private static ArrayList<Publisher> publishers = new ArrayList<>();

    public static ArrayList<Book> getBooks(){
        return new ArrayList<>(books);
    }
    public static ArrayList<Author> getAuthors(){
        return new ArrayList<>(authors);
    }
    public static ArrayList<Publisher> getPublishers(){
        return new ArrayList<>(publishers);
    }

    public static void addBook(Book book){
        if(!books.contains(book)){
            books.add(book);
        }
    }
    public static void addAuthor(Author author){
        if(!authors.contains(author)){
            authors.add(author);
        }
    }
    public static void addPublisher(Publisher publisher){
        if(!publishers.contains(publisher)){
            publishers.add(publisher);
        }
    }
}