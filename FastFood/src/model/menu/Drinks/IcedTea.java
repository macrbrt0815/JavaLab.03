package model.menu.Drinks;

import model.DrinksMenuType;

public class IcedTea extends DrinksMenuType{

    public IcedTea() {
        this.menuCode = "DR1";
        this.name = "Iced Tea";
        this.description = "Brewed from real leaves for balanced flavor. No artificial sweeteners or colors. " +
                "Available in several flavor options including lemon, raspberry, sweetened and unsweetened.";
        this.price = 75.00f;
    }
}
