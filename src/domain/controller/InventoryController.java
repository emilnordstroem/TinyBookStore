package domain.controller;

import domain.models.book.Book;
import domain.models.inventory.Stock;
import storage.StockStorage;

public class InventoryController {
    private static Stock createStock(Book book, int quantity){
        Stock newStock = new Stock(quantity, book);
        StockStorage.addStock(newStock);
        return newStock;
    }


}
