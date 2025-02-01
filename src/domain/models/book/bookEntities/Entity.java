package domain.models.book.bookEntities;

import domain.models.book.Book;

import java.util.ArrayList;
import java.util.Random;

public abstract class Entity {
    private String id;
    private ArrayList<Book> books;

    public Entity() {
        this.id = generateID();
        this.books = new ArrayList<>();
    }

    private static String generateID(){
        String id = String.valueOf(new Random().nextInt(111_111_111, 999_999_999));
        if(idAlreadyUsed(id)){
            generateID();
        }
        return id;
    }

    private static boolean idAlreadyUsed(String id) {
        ArrayList<Entity> entityArrayList = new ArrayList<>();
        for(Entity entity : entityArrayList) {
            if(entity.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
