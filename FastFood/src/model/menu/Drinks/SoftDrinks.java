package model.menu.Drinks;

import model.DrinksMenuType;

public class SoftDrinks extends DrinksMenuType {

    public SoftDrinks() {
        this.menuCode = "DR2";
        this.name = "Coca-Loca";
        this.description = "The cool, bubbly taste of Coca-Loca Classic is the perfect partner for sunny days and lunch with friends. " +
                "Grab a classic Coke to brighten your day at work, at home or out on an adventure with the people who matter most.";
        this.price = 60.00f;
    }
}
