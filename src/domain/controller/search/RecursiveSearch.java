package domain.controller.search;

import domain.models.book.interfaces.Searchable;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSearch<T extends Searchable<String>> {
    private static final int THRESHOLD = 10;
    private final List<T> searchResult = new ArrayList<>();

    protected RecursiveSearch(String searchKeyword, List<T> dataset) {
        searchAlgorithm(searchKeyword, dataset);
    }

    private void searchAlgorithm(String target, List<T> list){
        int left = 0;
        int right = list.size() - 1;
        int middle = (left + right) / 2;
        if(left > right){
            return;
        }
        if(list.size() <= THRESHOLD){
            linearSearch(target, list);
        } else {
            searchAlgorithm(target, list.subList(left, middle));
            searchAlgorithm(target, list.subList(middle + 1, right));
        }
    }

    private void linearSearch(String target, List<T> list){
        for(T item : list){
            if(item.matches(target) && !searchResult.contains(item)){
                searchResult.add(item);
            }
        }
    }

    public List<T> getSearchResult() {
        return searchResult;
    }
}
