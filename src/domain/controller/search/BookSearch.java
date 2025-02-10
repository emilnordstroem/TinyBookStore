package domain.controller.search;

import domain.models.book.Book;
import storage.BookStorage;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class BookSearch {
    private final ForkJoinPool pool = new ForkJoinPool();
    private final List<Book> books = BookStorage.getBookArrayList();

    public List<Book> search(String searchKeyword){
        ParallelSearch bookSearch = new ParallelSearch(books, searchKeyword);
        return pool.invoke(bookSearch);
    }
}
