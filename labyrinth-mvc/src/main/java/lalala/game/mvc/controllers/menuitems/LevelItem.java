package lalala.game.mvc.controllers.menuitems;

import lalala.game.mvc.view.IMenuView;

public class LevelItem implements IMenuItem {
    private IMenuView view;
    private final String name;

    public LevelItem(String name, IMenuView view) {
        this.view = view;
        this.name = name;
    }

    @Override
    public void execute() {
        view.show("On start");
        view.onItem(name);
    }
}
