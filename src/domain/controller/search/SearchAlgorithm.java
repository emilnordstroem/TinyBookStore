package domain.controller.search;

import domain.models.book.Book;
import domain.models.book.bookEntities.Author;
import domain.models.book.bookEntities.Publisher;
import domain.models.book.interfaces.Searchable;
import storage.BookEntityStorage;
import storage.BookStorage;

import java.util.ArrayList;

public class SearchAlgorithm<T extends Searchable<String>>{
    private final String searchKeyword;
    private SearchType searchType;
    private final ArrayList<T> searchResult = new ArrayList<>();

    protected SearchAlgorithm(String searchKeyword) {
        this.searchKeyword = searchKeyword;
        typeOfSearch();
        dynamicSearch();
    }

    // Issue the two: Author and Publisher isn't correct (should return all bookes associated with author)
    private void dynamicSearch() {
        if(searchType.equals(SearchType.BOOK)){
            searchAlgorithm((ArrayList<T>) BookStorage.getBookArrayList());
        } else if (searchType.equals(SearchType.AUTHOR)) {
            searchAlgorithm((ArrayList<T>) BookEntityStorage.getAuthorArrayList());
        } else if (searchType.equals(SearchType.PUBLISHER)) {
            searchAlgorithm((ArrayList<T>) BookEntityStorage.getPublisherArrayList());
        }
    }

    private void searchAlgorithm (ArrayList<T> collection){
        for(T entity : collection){
            if(entity.compareTo(searchKeyword) == 0){
                searchResult.add(entity);
            }
        }
    }

    private void typeOfSearch(){
        for(Book book : BookStorage.getBookArrayList()) {
            if (book.compareTo(searchKeyword) == 0) {
                searchType = SearchType.BOOK;
                break;
            }
        }
        for(Author author : BookEntityStorage.getAuthorArrayList()){
            if (author.compareTo(searchKeyword) == 0) {
                searchType = SearchType.AUTHOR;
                break;
            }
        }
        for(Publisher publisher : BookEntityStorage.getPublisherArrayList()){
            if (publisher.compareTo(searchKeyword) == 0) {
                searchType = SearchType.PUBLISHER;
                break;
            }
        }
    }

    protected ArrayList<T> getSearchResult() {
        return new ArrayList<>(searchResult);
    }
}