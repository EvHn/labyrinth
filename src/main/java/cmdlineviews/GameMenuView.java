package cmdlineviews;

import controllers.IMenuController;
import models.IMenu;
import view.IMenuView;

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
            CmdMainView.getInstance().setState("menu");
        } else {
            Map<String, String> options = new HashMap<>();
            options.put("levelName", itemName);
            CmdMainView.getInstance().setState("game", options);
        }
    }
}
