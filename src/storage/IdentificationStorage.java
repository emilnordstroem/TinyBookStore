package storage;

import java.util.ArrayList;

public class IdentificationStorage {
    private static ArrayList<String> bookISBNs = new ArrayList<>();
    private static ArrayList<String> publishersIDs = new ArrayList<>();
    private static ArrayList<String> authorsIDs = new ArrayList<>();
    private static ArrayList<Long> customersIDs = new ArrayList<>();
    private static ArrayList<String> orderIDs = new ArrayList<>();
    private static ArrayList<String> ratingIDs = new ArrayList<>();

    public static ArrayList<String> getBookISBNs(){
        return new ArrayList<>(bookISBNs);
    }
    public static ArrayList<String> getPublishersIDs(){
        return new ArrayList<>(publishersIDs);
    }
    public static ArrayList<String> getAuthorsIDs(){
        return new ArrayList<>(authorsIDs);
    }
    public static ArrayList<Long> getCustomersIDs(){
        return new ArrayList<>(customersIDs);
    }
    public static ArrayList<String> getOrderIDs(){
        return new ArrayList<>(orderIDs);
    }
    public static ArrayList<String> getRatingIDs(){
        return new ArrayList<>(ratingIDs);
    }

    public static void addBookISBN(String id){
        if(!bookISBNs.contains(id)){
            bookISBNs.add(id);
        }
    }
    public static void addPublisherID(String id){
        if(!publishersIDs.contains(id)){
            publishersIDs.add(id);
        }
    }
    public static void addAuthorID(String id){
        if(!authorsIDs.contains(id)){
            authorsIDs.add(id);
        }
    }
    public static void addCustomerID(Long id){
        if(!customersIDs.contains(id)){
            customersIDs.add(id);
        }
    }
    public static void addOrderID(String id){
        if(!orderIDs.contains(id)){
            orderIDs.add(id);
        }
    }
    public static void addRatingID(String id){
        if(!ratingIDs.contains(id)){
            ratingIDs.add(id);
        }
    }
}
