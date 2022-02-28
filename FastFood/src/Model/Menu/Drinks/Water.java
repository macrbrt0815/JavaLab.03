package Model.Menu.Drinks;

import Model.DrinksMenuType;

public class Water extends DrinksMenuType {

    public Water(){
        this.menuCode = "DR3";
        this.name = "Wilkins";
        this.description = "The cool, refreshing and fresh drink for rehydration. " +
                "This is safe to drink specially for babies and elders. ";
        this.price = 50.00f;
    }
}
