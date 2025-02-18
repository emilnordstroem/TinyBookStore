package domain.models.book.interfaces;

@FunctionalInterface
public interface Searchable <T>{

    /**
     * @param search
     * checks if argument passed is found in the entities class
     * @return
     * true if argument passed is found
     */
    boolean matches(T search);
}