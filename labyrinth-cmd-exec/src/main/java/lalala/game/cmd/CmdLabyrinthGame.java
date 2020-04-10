package lalala.game.cmd;

import lalala.game.cmd.cmdlineviews.CmdViewManager;
import lalala.game.core.utils.IDataLoader;
import lalala.game.core.utils.LocalDataLoader;
import lalala.game.mvc.controllers.GameMenuController;
import lalala.game.mvc.controllers.LabyrinthController;
import lalala.game.mvc.controllers.MenuController;
import lalala.game.mvc.models.Labyrinth;
import lalala.game.mvc.models.Menu;
import lalala.game.mvc.view.IViewFactory;

public class CmdLabyrinthGame {
    public static void main(String[] args) {
        init(CmdViewManager.getCmdViewFactory(), new LocalDataLoader(args[0]));
        CmdViewManager.getInstance().start();
    }

    public static void init(IViewFactory viewFactory, IDataLoader dataLoader) {
        new MenuController(new Menu(), viewFactory);
        new GameMenuController(new Menu(), viewFactory, dataLoader);
        new LabyrinthController(new Labyrinth(), viewFactory, dataLoader);
    }
}
