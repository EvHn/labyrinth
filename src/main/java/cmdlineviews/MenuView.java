package cmdlineviews;

import models.IMenu;

public class MenuView implements IMenuView {
    IMenu model;

    public MenuView(IMenu model) {
        this.model = model;
    }

    public void executeCommand(String command) {

    }

    @Override
    public void show() {
        model.getItemNames().stream().forEach(System.out::println);
    }

    @Override
    public void startGame() {

    }
}
