import cmdlineviews.CmdMainView;
import cmdlineviews.CmdViewFactory;
import controllers.LabyrinthController;
import controllers.MenuController;
import models.Labyrinth;
import models.Menu;
import view.IViewFactory;

public class LabyrinthGame {
    public static void main(String[] args) {
        IViewFactory viewFactory = new CmdViewFactory();
        new MenuController(new Menu(), viewFactory);
        new LabyrinthController(new Labyrinth(), viewFactory);
        CmdMainView.getInstance().start();
    }
}
