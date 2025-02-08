package storage;

import domain.models.book.bookEntities.Author;
import domain.models.book.bookEntities.BookEntity;
import domain.models.book.bookEntities.Publisher;

import java.util.ArrayList;

public class BookEntityStorage {
    private final static ArrayList<Publisher> publisherArrayList = new ArrayList<>();
    private final static ArrayList<Author> authorArrayList = new ArrayList<>();

    public static void addEntity(BookEntity entity){
        if(entity instanceof Publisher){
            if(!publisherArrayList.contains(entity)){
                publisherArrayList.add((Publisher) entity);
            }
        } else if(entity instanceof Author) {
            if(!authorArrayList.contains(entity)){
                authorArrayList.add((Author) entity);
            }
        }
    }

    public static void removeEntity(BookEntity entity){
        if(entity instanceof Publisher){
            publisherArrayList.remove(entity);
        } else if(entity instanceof Author) {
            authorArrayList.remove(entity);
        }
    }

    public static ArrayList<Publisher> getPublisherArrayList(){
        return new ArrayList<>(publisherArrayList);
    }

    public static ArrayList<Author> getAuthorArrayList(){
        return new ArrayList<>(authorArrayList);
    }
}
