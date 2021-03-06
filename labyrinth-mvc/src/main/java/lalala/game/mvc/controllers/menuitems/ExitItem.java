package lalala.game.mvc.controllers.menuitems;

import lalala.game.mvc.view.IMenuView;

public class ExitItem implements IMenuItem {
    IMenuView view;

    public ExitItem(IMenuView view) {
        this.view = view;
    }

    public void execute() {
        view.show("On exit");
        System.exit(0);
    }
}
