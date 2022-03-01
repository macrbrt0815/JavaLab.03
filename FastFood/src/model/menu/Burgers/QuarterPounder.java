package model.menu.Burgers;

import model.BurgerMenuType;

public class QuarterPounder extends BurgerMenuType {

    public QuarterPounder() {
        this.menuCode = "B2";
        this.name = "Quarter Pounder with Cheese";
        this.description = "Crisp shredded lettuce and three roma tomato slices top a 1/4 lb beef that's hot and deliciously juicy." +
                "Seasoned with just a pinch of salt and pepper, sizzled on a flat iron grill";
        this.price = 154.00f;
    }

}
