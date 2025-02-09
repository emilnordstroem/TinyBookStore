package domain.models.book.interfaces;

import domain.models.book.Book;

public interface Searchable <T> extends Comparable<T>{
    @Override
    int compareTo(T object);
}