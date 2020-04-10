package lalala.game.cmd.cmdlineviews;

import lalala.game.mvc.controllers.IMenuController;
import lalala.game.mvc.models.IMenu;
import lalala.game.mvc.view.IMenuView;

import java.util.HashMap;
import java.util.Map;

public class GameMenuView implements IMenuView, ICommandView {
    private IMenuController controller;
    private IMenu model;

    public GameMenuView(IMenuController controller, IMenu model) {
        this.controller = controller;
        this.model = model;
    }

    @Override
    public void init(Map<String, String> options) {}

    @Override
    public void executeCommand(String name) {
        controller.onItem(name);
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
        if("back".equals(itemName)) {
            CmdViewManager.getInstance().setState("menu");
        } else {
            Map<String, String> options = new HashMap<>();
            options.put("levelName", itemName);
            CmdViewManager.getInstance().setState("game", options);
        }
    }
}
