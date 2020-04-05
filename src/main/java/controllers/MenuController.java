package controllers;

import view.IMenuView;
import controllers.menuitems.ExitItem;
import controllers.menuitems.HelpItem;
import controllers.menuitems.StartItem;
import models.IMenu;
import view.IViewFactory;

public class MenuController implements IMenuController {
    public IMenu model;
    public IMenuView view;

    public MenuController(IMenu model, IViewFactory viewFactory) {
        this.model = model;
        this.view = viewFactory.createMenuView(this, model);
        model.addItem("exit", new ExitItem(view));
        model.addItem("start", new StartItem(view));
        model.addItem("help", new HelpItem(view));
    }

    @Override
    public void onItem(String itemName) {
        model.getItem(itemName).ifPresentOrElse(i -> i.execute(), () -> view.show("No such item"));
    }
}
