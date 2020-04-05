import cmdlineviews.CmdMainView;
import controllers.GameMenuController;
import controllers.LabyrinthController;
import controllers.MenuController;
import models.Labyrinth;
import models.Menu;
import utils.IUtilsFactory;
import utils.UtilsFactory;
import view.IViewFactory;

public class CmdLabyrinthGame {
    public static void main(String[] args) {
        init(CmdMainView.getCmdViewFactory(), new UtilsFactory());
        CmdMainView.getInstance().start();
    }

    public static void init(IViewFactory viewFactory, IUtilsFactory utilsFactory) {
        new MenuController(new Menu(), viewFactory, utilsFactory);
        new GameMenuController(new Menu(), viewFactory, utilsFactory);
        new LabyrinthController(new Labyrinth(), viewFactory);
    }
}
