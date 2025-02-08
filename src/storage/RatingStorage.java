package storage;

import domain.models.customer.Rating;

import java.util.ArrayList;

public class RatingStorage {
    private final static ArrayList<Rating> ratingArrayList = new ArrayList<>();

    public static void addRating(Rating order){
        if(!ratingArrayList.contains(order)){
            ratingArrayList.add(order);
        }
    }

    public static ArrayList<Rating> getRatingArrayList(){
        return new ArrayList<>(ratingArrayList);
    }
}
