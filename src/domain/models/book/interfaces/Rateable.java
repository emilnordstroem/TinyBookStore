package domain.models.book.interfaces;

import domain.models.customer.Rating;

import java.util.ArrayList;

public interface Rateable {
    void addRating(Rating rating);
    Rating getRating(Rating rating);
    double getAverageRating();
    void updateRecommendation(double averageRating);
}
