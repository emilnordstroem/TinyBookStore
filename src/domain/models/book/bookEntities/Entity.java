package domain.models.book.bookEntities;

import domain.models.book.Book;

import java.util.ArrayList;

public abstract class Entity {
    private static int id = 100_001;
    private ArrayList<Book> books;

    public Entity() {
        id += 1;
        this.books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
