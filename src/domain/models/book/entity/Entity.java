package domain.models.book.entity;

import domain.models.book.Book;

import java.util.ArrayList;

public class Entity {
    private String id;
    private ArrayList<Book> books;

    public Entity(String id, ArrayList<Book> books) {
        this.id = id;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
