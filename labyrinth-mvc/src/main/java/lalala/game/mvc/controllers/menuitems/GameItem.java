package lalala.game.mvc.controllers.menuitems;

import lalala.game.mvc.models.IMenu;
import lalala.game.mvc.view.IMenuView;

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
