package lalala.game.core.view;

import lalala.game.core.controllers.ILabyrinthController;
import lalala.game.core.controllers.IMenuController;
import lalala.game.core.models.ILabyrinth;
import lalala.game.core.models.IMenu;

public interface IViewFactory {
    IMenuView createMenuView(IMenuController controller, IMenu model);
    ILabyrinthView createLabyrinthView(ILabyrinthController controller, ILabyrinth model);
    IMenuView createGameMenuView(IMenuController controller, IMenu model);

}
