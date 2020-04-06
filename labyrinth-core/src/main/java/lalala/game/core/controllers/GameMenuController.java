package lalala.game.core.controllers;

import lalala.game.core.controllers.menuitems.BackItem;
import lalala.game.core.controllers.menuitems.HelpItem;
import lalala.game.core.controllers.menuitems.LevelItem;
import lalala.game.core.models.IMenu;
import lalala.game.core.utils.IItemProcessor;
import lalala.game.core.utils.IUtilsFactory;
import lalala.game.core.view.IMenuView;
import lalala.game.core.view.IViewFactory;

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
