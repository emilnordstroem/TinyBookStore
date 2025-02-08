package storage;

import domain.models.inventory.Stock;

import java.util.ArrayList;

public class StockStorage {
    private final static ArrayList<Stock> stockArrayList = new ArrayList<>();

    public static void addStock(Stock stock){
        if(!stockArrayList.contains(stock)){
            stockArrayList.add(stock);
        }
    }

    public static ArrayList<Stock> getStockArrayList(){
        return new ArrayList<>(stockArrayList);
    }

    public static void updateStockArrayList(Stock stock) {
        if (stockArrayList.contains(stock)) {
            stockArrayList.remove(stock);
            stockArrayList.add(stock);
        }
    }
}
