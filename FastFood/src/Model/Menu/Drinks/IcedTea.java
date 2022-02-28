package Model.Menu.Drinks;

import Model.DrinksMenuType;

public class IcedTea extends DrinksMenuType{

    public IcedTea() {
        this.menuCode = "DR1";
        this.name = "Lemon Iced Tea";
        this.description = "Brewed from real leaves for balanced flavor. No artificial sweeteners or colors. " +
                "Available in several flavor options including lemon, raspberry, sweetened and unsweetened.";
        this.price = 75.00f;
    }
}
