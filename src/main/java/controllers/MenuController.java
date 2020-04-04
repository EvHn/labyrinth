package controllers;

import cmdlineviews.IMenuView;
import controllers.menuitems.ExitItem;
import controllers.menuitems.HelpItem;
import controllers.menuitems.StartItem;
import models.IMenu;

public class MenuController implements IMenuController {
    public IMenu model;
    public IMenuView view;

    public MenuController(IMenu model, IMenuView view) {
        this.model = model;
        this.view = view;
        model.addItem("exit", new ExitItem(model, view));
        model.addItem("start", new StartItem(model, view));
        model.addItem("help", new HelpItem(view));
    }

    @Override
    public void onItem(String itemName) {
        model.getItem(itemName).ifPresentOrElse(i -> i.execute(), () -> System.out.println("No such item"));
    }
}
