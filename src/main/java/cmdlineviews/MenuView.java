package cmdlineviews;

import controllers.IMenuController;
import models.IMenu;
import view.IMenuView;

public class MenuView implements IMenuView, ICommandView {
    IMenu model;
    IMenuController controller;

    public MenuView(IMenuController controller, IMenu model) {
        this.model = model;
        this.controller = controller;
        CmdMainView.getInstance().putView("menu", this);
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
    public void startGame() {
        CmdMainView.getInstance().setState("game");
    }
}
