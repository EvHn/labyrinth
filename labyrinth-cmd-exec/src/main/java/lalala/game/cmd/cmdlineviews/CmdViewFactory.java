package lalala.game.cmd.cmdlineviews;


import lalala.game.mvc.controllers.ILabyrinthController;
import lalala.game.mvc.controllers.IMenuController;
import lalala.game.mvc.models.ILabyrinth;
import lalala.game.mvc.models.IMenu;
import lalala.game.mvc.view.ILabyrinthView;
import lalala.game.mvc.view.IMenuView;
import lalala.game.mvc.view.IViewFactory;

public class CmdViewFactory implements IViewFactory {

    CmdViewFactory() {}
    @Override
    public IMenuView createMenuView(IMenuController controller, IMenu model) {
        MenuView menuView = new MenuView(controller, model);
        CmdViewManager.getInstance().putView("menu", menuView);
        return menuView;
    }

    @Override
    public ILabyrinthView createLabyrinthView(ILabyrinthController controller, ILabyrinth model) {
        LabyrinthView labyrinthView = new LabyrinthView(controller, model);
        CmdViewManager.getInstance().putView("game", labyrinthView);
        return labyrinthView;
    }

    @Override
    public IMenuView createGameMenuView(IMenuController controller, IMenu model) {
        GameMenuView gameMenuView = new GameMenuView(controller, model);
        CmdViewManager.getInstance().putView("gameMenu", gameMenuView);
        return gameMenuView;
    }
}
