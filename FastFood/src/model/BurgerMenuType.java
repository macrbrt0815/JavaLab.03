package model;

import controller.Main;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BurgerMenuType implements MenuInterface, OrderInterface{
    final private static Logger logger = Logger.getLogger(BurgerMenuType.class.getName());

    protected String menuCode;
    protected String name;
    protected String description;
    protected float price;

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    @Override
    public void printOrder() {
        logger.log(Level.INFO, this.menuCode + " : " + this.name + " - Php " + this.price);
    }

    @Override
    public float getOrderPrice() {
        return this.getPrice();
    }

    @Override
    public void printMenu() {
       logger.log(Level.INFO,this.menuCode + " : " + this.name + " - Php " + this.price +
                "\n" + this.description + "\n");
    }
}
