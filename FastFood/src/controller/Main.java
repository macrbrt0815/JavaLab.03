package controller;

import model.*;
import model.menu.Burgers.CheeseBurger;
import model.menu.Burgers.QuarterPounder;
import model.menu.Desserts.Cake;
import model.menu.Desserts.IceCream;
import model.menu.Drinks.IcedTea;
import model.menu.Drinks.SoftDrinks;
import model.menu.Drinks.Water;
import model.menu.RiceMeals.BurgerSteakRice;
import model.menu.RiceMeals.FriedChickenRice;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    final private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        displayMenu();
        /*
        //trial implementation, for testing purposes
        BurgerMenuType cheeseBurger = new CheeseBurger();
        BurgerMenuType quarterPounder = new QuarterPounder();

        Order burgerOrders = new Order();
        burgerOrders.addOrder(cheeseBurger);
        burgerOrders.addOrder(quarterPounder);

        Order customerOrder = new Order();
        customerOrder.addOrder(burgerOrders);

        customerOrder.printOrder();
        */
    }

    public static void displayMenu(){
        RiceMealMenuType burgerSteak = new BurgerSteakRice();
        RiceMealMenuType friedChicken = new FriedChickenRice();

        Menu riceMeals = new Menu();
        riceMeals.addMenu(burgerSteak);
        riceMeals.addMenu(friedChicken);

        BurgerMenuType cheeseBurger = new CheeseBurger();
        BurgerMenuType quarterPounder = new QuarterPounder();

        Menu burgers = new Menu();
        burgers.addMenu(cheeseBurger);
        burgers.addMenu(quarterPounder);

        DrinksMenuType icedTea = new IcedTea();
        DrinksMenuType softDrinks = new SoftDrinks();
        DrinksMenuType waterBottle = new Water();

        Menu drinks = new Menu();
        drinks.addMenu(icedTea);
        drinks.addMenu(softDrinks);
        drinks.addMenu(waterBottle);

        DessertMenuType cake = new Cake();
        DessertMenuType iceCream = new IceCream();

        Menu desserts = new Menu();
        desserts.addMenu(cake);
        desserts.addMenu(iceCream);

        Menu menu = new Menu();
        menu.addMenu(riceMeals);
        menu.addMenu(burgers);
        menu.addMenu(drinks);
        menu.addMenu(desserts);

        logger.log(Level.INFO, "Fast Food Menu: ");
        menu.printMenu();
    }
}
