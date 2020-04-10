package lalala.game.mvc.controllers;

import lalala.game.mvc.controllers.menuitems.ExitItem;
import lalala.game.mvc.controllers.menuitems.GameItem;
import lalala.game.mvc.controllers.menuitems.HelpItem;
import lalala.game.mvc.models.IMenu;
import lalala.game.mvc.untils.IItemProcessor;
import lalala.game.mvc.untils.ItemProcessor;
import lalala.game.mvc.view.IMenuView;
import lalala.game.mvc.view.IViewFactory;

public class MenuController implements IMenuController {
    public IMenu model;
    public IMenuView view;
    public IItemProcessor itemProcessor;

    public MenuController(IMenu model, IViewFactory viewFactory) {
        this.model = model;
        this.view = viewFactory.createMenuView(this, model);
        this.itemProcessor = new ItemProcessor(model, view);
        model.addItem("exit", new ExitItem(view));
        model.addItem("game", new GameItem(model, view));
        model.addItem("help", new HelpItem(view));
    }

    @Override
    public void onItem(String itemName) {
        itemProcessor.process(itemName);
    }
}
