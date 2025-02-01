package domain.models.book.bookEntities;

public class Publisher extends Entity {
    private String firstName;
    private String lastName;

    public Publisher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
