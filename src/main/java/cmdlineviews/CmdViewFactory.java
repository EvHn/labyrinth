package cmdlineviews;

import controllers.ILabyrinthController;
import controllers.IMenuController;
import models.ILabyrinth;
import models.IMenu;
import view.ILabyrinthView;
import view.IMenuView;
import view.IViewFactory;

public class CmdViewFactory implements IViewFactory {
    @Override
    public IMenuView createMenuView(IMenuController controller, IMenu model) {
        return new MenuView(controller, model);
    }

    @Override
    public ILabyrinthView createLabyrinthView(ILabyrinthController controller, ILabyrinth model) {
        return new LabyrinthView(controller, model);
    }
}
