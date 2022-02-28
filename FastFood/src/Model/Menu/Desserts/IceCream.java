package Model.Menu.Desserts;

import Model.DessertMenuType;

public class IceCream extends DessertMenuType {

    public IceCream() {
        this.menuCode = "D2";
        this.name = "Banana Split";
        this.description = "A classic American sundae consisting of a split banana, three scoops of ice cream, " +
                "and several or all of the following: whipped cream or marshmallow cream, pineapple sauce, cherry sauce, " +
                "fudge sauce, caramel sauce, peanuts, and at least one cherry.";
        this.price = 90.00f;
    }
}
