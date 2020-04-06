package lalala.game.cmd;

import lalala.game.cmd.cmdlineviews.CmdMainView;
import lalala.game.core.controllers.GameMenuController;
import lalala.game.core.controllers.LabyrinthController;
import lalala.game.core.controllers.MenuController;
import lalala.game.core.models.Labyrinth;
import lalala.game.core.models.Menu;
import lalala.game.core.utils.IUtilsFactory;
import lalala.game.core.utils.UtilsFactory;
import lalala.game.core.view.IViewFactory;

public class CmdLabyrinthGame {
    public static void main(String[] args) {
        init(CmdMainView.getCmdViewFactory(), new UtilsFactory());
        CmdMainView.getInstance().start();
    }

    public static void init(IViewFactory viewFactory, IUtilsFactory utilsFactory) {
        new MenuController(new Menu(), viewFactory, utilsFactory);
        new GameMenuController(new Menu(), viewFactory, utilsFactory);
        new LabyrinthController(new Labyrinth(), viewFactory, utilsFactory);
    }
}
