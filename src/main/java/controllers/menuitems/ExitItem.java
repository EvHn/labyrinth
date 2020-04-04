package controllers.menuitems;

import cmdlineviews.IMenuView;
import models.IMenu;

public class ExitItem implements IMenuItem {
    IMenu model;
    IMenuView view;

    public ExitItem(IMenu model, IMenuView view) {
        this.model = model;
        this.view = view;
    }

    public void execute() {
        System.out.println("On exit");
        System.exit(0);
    }
}
