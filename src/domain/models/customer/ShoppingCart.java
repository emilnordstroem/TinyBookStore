package domain.models.customer;
import domain.models.book.Book;
import domain.models.stock.Stock;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Stock> bookStocks;
    private double estimatedPrice = 0;

    public ShoppingCart() {
        this.bookStocks = new ArrayList<>();
    }

    public double calculatePrice(){
        double sum = 0;
        for(Stock stock : bookStocks){
            sum += stock.getBook().getPrice();
        }
        return sum;
    }

    public boolean isBookAvailable (Book book, int quality) {
        for(Stock stock : bookStocks){
            if(stock.getBook().equals(book)){
                return (stock.getQuantity() - quality) > 0;
            }
        }
        return false;
    }

    public double getEstimatedPrice() {
        return estimatedPrice;
    }
}
