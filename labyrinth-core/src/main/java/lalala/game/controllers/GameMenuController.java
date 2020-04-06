package controllers;

import controllers.menuitems.BackItem;
import controllers.menuitems.HelpItem;
import controllers.menuitems.LevelItem;
import models.IMenu;
import utils.IItemProcessor;
import utils.IUtilsFactory;
import view.IMenuView;
import view.IViewFactory;

public class GameMenuController implements IMenuController {
    IMenu model;
    IMenuView view;
    IItemProcessor itemProcessor;

    public GameMenuController(IMenu model, IViewFactory viewFactory, IUtilsFactory utilsFactory) {
        this.model = model;
        this.view = viewFactory.createGameMenuView(this, model);
        utilsFactory.createDataLoader().loadConfig().ifPresentOrElse(
                config -> config.getLevels().keySet().stream().forEach(i -> model.addItem(i, new LevelItem(i, view))),
                () -> view.show("Error loading config"));
        itemProcessor = utilsFactory.createItemProcessor(model, view);
        model.addItem("exit", new BackItem(view));
        model.addItem("help", new HelpItem(view));
    }

    @Override
    public void onItem(String itemName) {
        itemProcessor.process(itemName);
    }
}
