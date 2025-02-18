package storage.toBeTerminated;

import domain.models.book.Book;
import java.util.ArrayList;

public class BookStorage {
    private final static ArrayList<Book> bookArrayList = new ArrayList<>();

    public static void addBook(Book book){
        if(!bookArrayList.contains(book)){
            bookArrayList.add(book);
        }
    }
    public static ArrayList<Book> getBookArrayList(){
        return new ArrayList<>(bookArrayList);
    }
    public static void removeBook(Book book){
        bookArrayList.remove(book);
    }
}
