package lalala.game.mvc.view;

import lalala.game.mvc.controllers.ILabyrinthController;
import lalala.game.mvc.controllers.IMenuController;
import lalala.game.mvc.models.ILabyrinth;
import lalala.game.mvc.models.IMenu;

public interface IViewFactory {
    IMenuView createMenuView(IMenuController controller, IMenu model);
    ILabyrinthView createLabyrinthView(ILabyrinthController controller, ILabyrinth model);
    IMenuView createGameMenuView(IMenuController controller, IMenu model);

}
