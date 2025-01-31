package domain.models.book.entity;

import storage.IdentificationStorage;
import java.util.ArrayList;
import java.util.Random;

public class Author extends Entity {
    private String firstName;
    private String lastName;

    public Author(String firstName, String lastName) {
        super(Author.generateID(), new ArrayList<>());
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private static String generateID(){
        String id = String.valueOf(new Random().nextInt(111_111_111, 999_999_999));
        if(IdentificationStorage.getAuthorsIDs().contains(id)){
            generateID();
        }
        IdentificationStorage.addAuthorID(id);
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
