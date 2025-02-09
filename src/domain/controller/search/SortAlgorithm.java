package domain.controller.search;

import domain.models.book.Book;
import domain.models.book.bookEntities.Author;
import domain.models.book.interfaces.Searchable;

import java.util.ArrayList;

public class SortAlgorithm <T extends Searchable<String>> {
    private final ArrayList<T> sortedArrayList;

    protected SortAlgorithm(ArrayList<T> unsortedCollection) {
        sortedArrayList = sortAlgorithm(unsortedCollection);
    }


    private ArrayList<T> sortAlgorithm(ArrayList<T> unsortedCollection){
        return new ArrayList<>();
    }

    protected ArrayList<T> getSortedArrayList() {
        return new ArrayList<>(sortedArrayList);
    }
}
