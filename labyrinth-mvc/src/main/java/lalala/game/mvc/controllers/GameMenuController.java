package lalala.game.mvc.controllers;

import lalala.game.core.utils.IDataLoader;
import lalala.game.mvc.controllers.menuitems.BackItem;
import lalala.game.mvc.controllers.menuitems.HelpItem;
import lalala.game.mvc.controllers.menuitems.LevelItem;
import lalala.game.mvc.models.IMenu;
import lalala.game.mvc.untils.IItemProcessor;
import lalala.game.mvc.untils.ItemProcessor;
import lalala.game.mvc.view.IMenuView;
import lalala.game.mvc.view.IViewFactory;

public class GameMenuController implements IMenuController {
    private IMenu model;
    private IMenuView view;
    private IItemProcessor itemProcessor;

    public GameMenuController(IMenu model, IViewFactory viewFactory, IDataLoader dataLoader) {
        this.model = model;
        this.view = viewFactory.createGameMenuView(this, model);
        dataLoader.loadConfig().ifPresentOrElse(
                config -> config.getLevels().keySet().stream().forEach(i -> model.addItem(i, new LevelItem(i, view))),
                () -> view.show("Error loading config"));
        itemProcessor = new ItemProcessor(model, view);
        model.addItem("exit", new BackItem(view));
        model.addItem("help", new HelpItem(view));
    }

    @Override
    public void onItem(String itemName) {
        itemProcessor.process(itemName);
    }
}
