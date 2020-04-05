package controllers.menuitems;

import view.IMenuView;

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
