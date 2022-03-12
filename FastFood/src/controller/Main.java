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
import utilities.Helper;
import utilities.proxy.database.Database;
import utilities.proxy.database.DatabaseProxy;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    final private static Logger logger = Logger.getLogger(Main.class.getName());

    static String firstName;
    static String lastName;
    static float grossAmount = 0.0f;

    public static void main(String[] args) throws IOException {
        displayMenu();
        createOrder();
        completeOrder();
    }

    public static void displayMenu(){
        BurgerMenuType cheeseBurger = new CheeseBurger();
        BurgerMenuType quarterPounder = new QuarterPounder();

        Menu burgers = new Menu();
        burgers.addMenu(cheeseBurger);
        burgers.addMenu(quarterPounder);

        DessertMenuType cake = new Cake();
        DessertMenuType iceCream = new IceCream();

        Menu desserts = new Menu();
        desserts.addMenu(cake);
        desserts.addMenu(iceCream);

        DrinksMenuType icedTea = new IcedTea();
        DrinksMenuType softDrinks = new SoftDrinks();
        DrinksMenuType waterBottle = new Water();

        Menu drinks = new Menu();
        drinks.addMenu(icedTea);
        drinks.addMenu(softDrinks);
        drinks.addMenu(waterBottle);

        RiceMealMenuType burgerSteak = new BurgerSteakRice();
        RiceMealMenuType friedChicken = new FriedChickenRice();

        Menu riceMeals = new Menu();
        riceMeals.addMenu(burgerSteak);
        riceMeals.addMenu(friedChicken);

        Menu menu = new Menu();
        menu.addMenu(riceMeals);
        menu.addMenu(burgers);
        menu.addMenu(drinks);
        menu.addMenu(desserts);

        logger.log(Level.INFO, "Fast Food Menu: ");
        menu.printMenu();
    }

    public static void createOrder() throws IOException {
        String choice;
        String menuCode;
        float vat = 0.0f;
        float vatRate = 0.12f;
        float netAmount = 0.0f;

        Order burgerOrders = new Order();
        Order dessertOrders = new Order();
        Order drinkOrders = new Order();
        Order riceMealOrders = new Order();

        Order customerOrder = new Order();

        firstName = Helper.getStringInput("Enter customer first name: ").toUpperCase();
        lastName = Helper.getStringInput("Enter customer last name: ").toUpperCase();

        logger.log(Level.INFO,"What do you want to order? ");

        do{
            menuCode = Helper.getStringInput("Enter menu code: ");

            switch(menuCode.toUpperCase()){
                case "B1":
                    BurgerMenuType cheeseBurger = new CheeseBurger();
                    burgerOrders.addOrder(cheeseBurger);
                    break;
                case "B2":
                    BurgerMenuType quarterPounder = new QuarterPounder();
                    burgerOrders.addOrder(quarterPounder);
                    break;
                case "D1":
                    DessertMenuType cake = new Cake();
                    dessertOrders.addOrder(cake);
                    break;
                case "D2":
                    DessertMenuType iceCream = new IceCream();
                    dessertOrders.addOrder(iceCream);
                    break;
                case "DR1":
                    DrinksMenuType icedTea = new IcedTea();
                    drinkOrders.addOrder(icedTea);
                    break;
                case "DR2":
                    DrinksMenuType softDrinks = new SoftDrinks();
                    drinkOrders.addOrder(softDrinks);
                    break;
                case "DR3":
                    DrinksMenuType waterBottle = new Water();
                    drinkOrders.addOrder(waterBottle);
                    break;
                case "RM1":
                    RiceMealMenuType burgerSteak = new BurgerSteakRice();
                    riceMealOrders.addOrder(burgerSteak);
                    break;
                case "RM2":
                    RiceMealMenuType friedChicken = new FriedChickenRice();
                    riceMealOrders.addOrder(friedChicken);
                    break;
                default:
                    logger.log(Level.INFO,"Invalid menu Code!");
                    break;
            }
            choice = Helper.getStringInput("Do you want to add another order? [YES/NO]");
        }while(choice.equalsIgnoreCase("YES"));

        customerOrder.addOrder(burgerOrders);
        customerOrder.addOrder(dessertOrders);
        customerOrder.addOrder(drinkOrders);
        customerOrder.addOrder(riceMealOrders);

        logger.log(Level.INFO, "Customer Name: " + firstName + " " + lastName);
        logger.log(Level.INFO, "Orders: ");
        customerOrder.printOrder();
        grossAmount = customerOrder.getOrderPrice();
        vat = grossAmount * vatRate;
        netAmount = grossAmount - vat;
        logger.log(Level.INFO, "Total Amount Due: " + grossAmount + "\n"
                + "Net Amount: " + netAmount + "\n"
                + "VAT: " + vat);
    }

    public static void completeOrder(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Database database = new DatabaseProxy();

        String transactionID = "Transaction " + String.valueOf(database.getTotalTransactions() + 1);
        Transaction transaction = new Transaction(transactionID, firstName + " " + lastName, grossAmount, LocalDateTime.now().format(format));

        database.insertTransaction(transaction);
    }
}
