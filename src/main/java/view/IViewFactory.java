package view;

import controllers.ILabyrinthController;
import controllers.IMenuController;
import models.ILabyrinth;
import models.IMenu;

public interface IViewFactory {
    IMenuView createMenuView(IMenuController controller, IMenu model);
    ILabyrinthView createLabyrinthView(ILabyrinthController controller, ILabyrinth model);
    IMenuView createGameMenuView(IMenuController controller, IMenu model);

}
