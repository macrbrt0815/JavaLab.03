package model;

import controller.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Order implements OrderInterface{
    final private static Logger logger = Logger.getLogger(Order.class.getName());

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

    @Override
    public float getOrderPrice() {
        float total = 0f;
        for(OrderInterface order : customerOrder){
            total += order.getOrderPrice();
        }
        return total;
    }

}
