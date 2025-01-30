package domain.models;

import storage.IdentificationStorage;

import java.util.ArrayList;
import java.util.Random;

public class Publisher extends Entity{
    private String firstName;
    private String lastName;

    public Publisher(String firstName, String lastName) {
        super(Publisher.generateID(), new ArrayList<>());
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private static String generateID(){
        String id = String.valueOf(new Random().nextInt(111_111_111, 999_999_999));
        if(IdentificationStorage.getPublishersIDs().contains(id)){
            generateID();
        }
        IdentificationStorage.addPublisherID(id);
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
