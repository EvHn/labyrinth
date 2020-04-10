package lalala.game.mvc.controllers.menuitems;

import lalala.game.mvc.view.IMenuView;

public class BackItem implements IMenuItem {
    IMenuView view;

    public BackItem(IMenuView view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.onItem("back");
    }
}
