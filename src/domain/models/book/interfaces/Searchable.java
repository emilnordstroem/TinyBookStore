package domain.models.book.interfaces;

import domain.models.book.Book;

public interface Searchable <T> extends Comparable<T>{

    /**
     * @param search
     * checks if argument passed is found in the entities class
     * @return
     * true if argument passed is found
     */
    boolean matches(T search);


    @Override
    int compareTo(T object);
}