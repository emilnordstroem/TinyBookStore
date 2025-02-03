package domain.models.book.bookEntities;

public class Publisher extends Entity {
    private String name;

    public Publisher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
