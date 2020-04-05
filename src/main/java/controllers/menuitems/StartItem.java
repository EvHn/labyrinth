package controllers.menuitems;

import view.IMenuView;
import models.IMenu;

public class StartItem implements IMenuItem {
    IMenuView view;

    public StartItem(IMenuView view) {
        this.view = view;
    }

    public void execute() {
        view.show("On start");
        view.startGame();
    }
}
