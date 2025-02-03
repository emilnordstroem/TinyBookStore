package domain.models.order;

import domain.models.book.Book;
import domain.models.stock.Stock;
import domain.models.stock.StockStatus;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderList {
    private ArrayList<Stock> bookStocks;
    private ArrayList<HashMap<Book, StockStatus>> books;

    public OrderList(ArrayList<Stock> bookStocks) {
        this.bookStocks = bookStocks;
        this.books = booksHashMap();
    }

    private ArrayList<HashMap<Book, StockStatus>> booksHashMap(){
        ArrayList<HashMap<Book, StockStatus>> books = new ArrayList<>();
        for(Stock stock : bookStocks){
            HashMap<Book, StockStatus> book = new HashMap<>();
            book.put(stock.getBook(), stock.getStatus());
            books.add(book);
        }
        return books;
    }

    public void updateOrderList(){
        books.clear();
        books.addAll(booksHashMap());
    }

    public ArrayList<HashMap<Book, StockStatus>> getBooks() {
        return new ArrayList<>(books);
    }
}
