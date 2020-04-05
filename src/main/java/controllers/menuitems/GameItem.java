package controllers.menuitems;

import models.IMenu;
import view.IMenuView;

public class GameItem implements IMenuItem {
    IMenuView view;
    IMenu model;

    public GameItem(IMenu model, IMenuView view) {
        this.view = view;
        this.model = model;
    }

    public void execute() {
        view.onItem("game");
    }
}
