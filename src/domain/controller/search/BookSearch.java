package domain.controller.search;

import domain.models.book.Book;
import storage.BookStorage;

import java.util.ArrayList;

public class BookSearch {
    ArrayList<Book> datasetArrayList;
    ArrayList<Book> searchResult;

    public BookSearch(String searchKeyword) {
        this.datasetArrayList = BookStorage.getBookArrayList();
//        SortAlgorithm<Book> sortedDataSet = new SortAlgorithm<>(datasetArrayList);
        SearchAlgorithm<Book> searchResult = new SearchAlgorithm<>(searchKeyword);
        this.searchResult = searchResult.getSearchResult();
    }

    public ArrayList<Book> getSearchResult() {
        return searchResult;
    }
}
