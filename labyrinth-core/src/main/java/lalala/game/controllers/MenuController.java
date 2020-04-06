package controllers;

import utils.IItemProcessor;
import utils.IUtilsFactory;
import view.IMenuView;
import controllers.menuitems.ExitItem;
import controllers.menuitems.HelpItem;
import controllers.menuitems.GameItem;
import models.IMenu;
import view.IViewFactory;

public class MenuController implements IMenuController {
    public IMenu model;
    public IMenuView view;
    public IItemProcessor itemProcessor;

    public MenuController(IMenu model, IViewFactory viewFactory, IUtilsFactory utilsFactory) {
        this.model = model;
        this.view = viewFactory.createMenuView(this, model);
        this.itemProcessor = utilsFactory.createItemProcessor(model, view);
        model.addItem("exit", new ExitItem(view));
        model.addItem("game", new GameItem(model, view));
        model.addItem("help", new HelpItem(view));
    }

    @Override
    public void onItem(String itemName) {
        itemProcessor.process(itemName);
    }
}
