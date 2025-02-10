package domain.controller.search;

import domain.models.book.Book;
import storage.BookStorage;

import java.util.ArrayList;

public class BookSearch {
    private final ArrayList<Book> dataset = BookStorage.getBookArrayList();
    ArrayList<Book> searchResult = new ArrayList<>();

    public BookSearch(String searchKeyword) {
        this.searchResult = searchAlgorithm(searchKeyword);
    }

    private ArrayList<Book> searchAlgorithm(String searchKeyword){
        ArrayList<Book> matchingBooks = new ArrayList<>();

        for(Book book : dataset){
            if(book.matches(searchKeyword.toLowerCase())){
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }

    public ArrayList<Book> getSearchResult() {
        return searchResult;
    }
}
