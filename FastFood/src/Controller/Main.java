package Controller;

import Model.BurgerMenuType;
import Model.Menu.Burgers.CheeseBurger;
import Model.Menu.Burgers.QuarterPounder;
import Model.Order;

public class Main {
    public static void main(String[] args) {
        //trial implementation, for testing purposes
        BurgerMenuType cheeseBurger = new CheeseBurger();
        BurgerMenuType quarterPounder = new QuarterPounder();

        Order burgerOrders = new Order();
        burgerOrders.addOrder(cheeseBurger);
        burgerOrders.addOrder(quarterPounder);

        Order customerOrder = new Order();
        customerOrder.addOrder(burgerOrders);

        customerOrder.printOrder();

    }
}
