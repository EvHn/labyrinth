package lalala.game.core.controllers;

import lalala.game.core.controllers.menuitems.ExitItem;
import lalala.game.core.controllers.menuitems.GameItem;
import lalala.game.core.controllers.menuitems.HelpItem;
import lalala.game.core.models.IMenu;
import lalala.game.core.utils.IItemProcessor;
import lalala.game.core.utils.IUtilsFactory;
import lalala.game.core.view.IMenuView;
import lalala.game.core.view.IViewFactory;

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
