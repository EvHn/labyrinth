package controllers.menuitems;

import cmdlineviews.IMenuView;
import models.IMenu;

public class StartItem implements IMenuItem {
    IMenu model;
    IMenuView view;

    public StartItem(IMenu model, IMenuView view) {
        this.model = model;
        this.view = view;
    }

    public void execute() {
        System.out.println("On start");
    }
}
