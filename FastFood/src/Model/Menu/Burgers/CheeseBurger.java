package Model.Menu.Burgers;

import Model.BurgerMenuType;

public class CheeseBurger extends BurgerMenuType {

    public CheeseBurger() {
        this.menuCode = "B1";
        this.name = "Cheese Burger";
        this.description = "A traditional grilled sandwich that consists of ground meat made into a patty, " +
                "cooked, topped with a slice of cheese, and placed between two halves of a bun.";
        this.price = 66.00f;
    }
}
