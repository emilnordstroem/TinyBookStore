package domain.controller.search;

import domain.models.book.Book;
import storage.BookStorage;

import java.util.List;

public class BookSearch {
    private final List<Book> books = BookStorage.getBookArrayList();

    public List<Book> search(String searchKeyword){
        RecursiveSearch<Book> bookSearch = new RecursiveSearch<>(searchKeyword, books);
        return bookSearch.getSearchResult();
    }
}
