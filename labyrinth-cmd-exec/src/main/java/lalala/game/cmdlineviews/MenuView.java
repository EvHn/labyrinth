package lalala.game.cmdlineviews;

import controllers.IMenuController;
import models.IMenu;
import view.IMenuView;

import java.util.Map;

public class MenuView implements IMenuView, ICommandView {
    IMenu model;
    IMenuController controller;

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
            CmdMainView.getInstance().setState("gameMenu");
        }
    }

    @Override
    public void init(Map<String, String> options) {

    }
}
