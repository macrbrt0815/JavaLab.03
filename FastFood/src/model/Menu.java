package model;

import controller.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Menu implements MenuInterface{
    final private static Logger logger = Logger.getLogger(Main.class.getName());

    private List<MenuInterface> menu = new ArrayList<>();

    public void addMenu(MenuInterface menuItems){
        menu.add(menuItems);
    }

    public void removeMenu(MenuInterface menuItems){
        menu.remove(menuItems);
    }

    @Override
    public void printMenu() {
        menu.forEach(MenuInterface::printMenu);
    }
}
