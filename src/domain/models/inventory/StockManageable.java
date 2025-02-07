package domain.models.inventory;

public interface StockManageable {
    int updateStock(int quantity);
    boolean updateAvailability();
}
