package lalala.game.cmd.cmdlineviews;

import lalala.game.mvc.controllers.IMenuController;
import lalala.game.mvc.models.IMenu;
import lalala.game.mvc.view.IMenuView;

import java.util.Map;

public class MenuView implements IMenuView, ICommandView {
    private IMenu model;
    private IMenuController controller;

    public MenuView(IMenuController controller, IMenu model) {
        this.model = model;
        this.controller = controller;
    }

    public void executeCommand(String command) {
        controller.onItem(command);
    }

    @Override
    public void showHelp() {
        model.getItemNames().stream().forEach(System.out::println);
    }

    @Override
    public void show(String message) {
        System.out.println(message);
    }

    @Override
    public void onItem(String itemName) {
        if("game".equals(itemName)) {
            CmdViewManager.getInstance().setState("gameMenu");
        }
    }

    @Override
    public void init(Map<String, String> options) {

    }
}
