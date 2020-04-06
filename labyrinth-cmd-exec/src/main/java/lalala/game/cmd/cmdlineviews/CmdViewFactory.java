package lalala.game.cmd.cmdlineviews;


import lalala.game.core.controllers.ILabyrinthController;
import lalala.game.core.controllers.IMenuController;
import lalala.game.core.models.ILabyrinth;
import lalala.game.core.models.IMenu;
import lalala.game.core.view.ILabyrinthView;
import lalala.game.core.view.IMenuView;
import lalala.game.core.view.IViewFactory;

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
