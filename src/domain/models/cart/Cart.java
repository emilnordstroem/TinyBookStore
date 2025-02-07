package domain.models.cart;

import domain.models.book.Book;

import java.util.ArrayList;

public class Cart {
    private static long id = 10_000L;
    private ArrayList<CartItem> items = new ArrayList<>();

    public Cart() {
        id += 1;
    }

    public double calculatePrice(){
        double totalPrice = 0;
        for(CartItem item : items){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public void addItem(Book book, int quality){
        boolean bookExisted = false;
        for(CartItem item : items){
            if(item.getBook().equals(book)){
                item.setQuantity(quality);
                bookExisted = true;
                break;
            }
        }
        if(!bookExisted){
            items.add(new CartItem(book, quality, book.getprice()));
        }
    }

    public void removeItem(CartItem item){
        items.remove(item);
    }
}