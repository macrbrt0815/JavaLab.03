package model;

import java.util.ArrayList;
import java.util.List;

public class Order implements OrderInterface{
    private List<OrderInterface> customerOrder = new ArrayList<>();

    public void addOrder(OrderInterface order){
        customerOrder.add(order);
    }

    public void removeOrder(OrderInterface order){
        customerOrder.remove(order);
    }

    @Override
    public void printOrder() {
        customerOrder.forEach(OrderInterface::printOrder);
    }
}
