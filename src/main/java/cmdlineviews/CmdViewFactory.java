package cmdlineviews;

import controllers.ILabyrinthController;
import controllers.IMenuController;
import models.ILabyrinth;
import models.IMenu;
import view.ILabyrinthView;
import view.IMenuView;
import view.IViewFactory;

public class CmdViewFactory implements IViewFactory {

    CmdViewFactory() {}
    @Override
    public IMenuView createMenuView(IMenuController controller, IMenu model) {
        MenuView menuView = new MenuView(controller, model);
        CmdMainView.getInstance().putView("menu", menuView);
        return menuView;
    }

    @Override
    public ILabyrinthView createLabyrinthView(ILabyrinthController controller, ILabyrinth model) {
        LabyrinthView labyrinthView = new LabyrinthView(controller, model);
        CmdMainView.getInstance().putView("game", labyrinthView);
        return labyrinthView;
    }

    @Override
    public IMenuView createGameMenuView(IMenuController controller, IMenu model) {
        GameMenuView gameMenuView = new GameMenuView(controller, model);
        CmdMainView.getInstance().putView("gameMenu", gameMenuView);
        return gameMenuView;
    }
}
