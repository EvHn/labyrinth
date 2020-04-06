package controllers.menuitems;

import view.IMenuView;

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
