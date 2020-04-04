package controllers.menuitems;

import cmdlineviews.IMenuView;

public class HelpItem implements IMenuItem {
    IMenuView view;

    public HelpItem(IMenuView view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.show();
    }
}
