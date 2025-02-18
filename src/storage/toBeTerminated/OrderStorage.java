package storage.toBeTerminated;

import domain.models.order.Order;

import java.util.ArrayList;

public class OrderStorage {
    private final static ArrayList<Order> orderArrayList = new ArrayList<>();

    public static void addOrder(Order order){
        if(!orderArrayList.contains(order)){
            orderArrayList.add(order);
        }
    }

    public static ArrayList<Order> getOrderArrayList(){
        return new ArrayList<>(orderArrayList);
    }

}
