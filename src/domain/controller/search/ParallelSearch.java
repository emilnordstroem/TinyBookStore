package domain.controller.search;

import domain.models.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ParallelSearch extends RecursiveTask<List<Book>>{
    private static final int THRESHOLD = 10;
    private final List<Book> dataset;
    private final String searchKeyword;

    protected ParallelSearch(List<domain.models.book.Book> dataset, String searchKeyword) {
        this.dataset = dataset;
        this.searchKeyword = searchKeyword;
    }

    @Override
    protected List<Book> compute() {
        if(dataset.size() <= THRESHOLD){
            return linearSearch();
        } else {
            int middle = dataset.size() / 2;
            ParallelSearch leftSearch = new ParallelSearch(dataset.subList(0, middle), searchKeyword);
            ParallelSearch rightSearch = new ParallelSearch(dataset.subList(middle, dataset.size()), searchKeyword);

            leftSearch.fork();
            List<domain.models.book.Book> rightSearchResult = rightSearch.compute();
            List<domain.models.book.Book> leftSearchResult = leftSearch.compute();

            leftSearchResult.addAll(rightSearchResult);
            return leftSearchResult;
        }
    }

    private List<Book> linearSearch(){
        List<Book> result = new ArrayList<>();
        for(Book book : dataset){
            if(book.matches(searchKeyword)){
                result.add(book);
            }
        }
        return result;
    }
}
