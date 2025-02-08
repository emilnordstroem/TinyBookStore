package domain.models.inventory;

public interface StockManageable {
    void updateStock(int quantity);
    void updateAvailability();
}
