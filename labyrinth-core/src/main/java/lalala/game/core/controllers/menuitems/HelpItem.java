package lalala.game.core.controllers.menuitems;

import lalala.game.core.view.IMenuView;

public class HelpItem implements IMenuItem {
    IMenuView view;

    public HelpItem(IMenuView view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.showHelp();
    }
}
