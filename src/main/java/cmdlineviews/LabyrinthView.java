package cmdlineviews;

import controllers.ILabyrinthController;
import models.ILabyrinth;
import models.ILabyrinthObserver;
import view.ILabyrinthView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LabyrinthView implements ILabyrinthView, ICommandView, ILabyrinthObserver {
    ILabyrinthController controller;
    ILabyrinth model;
    Map<String, Runnable> commandMap;

    public LabyrinthView(ILabyrinthController controller, ILabyrinth model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver(this);
        commandMap = new HashMap<>();
        commandMap.put("exit", controller::exit);
        enableControl();
        commandMap.put("restart", controller::restart);
        commandMap.put("help", controller::help);
        CmdMainView.getInstance().putView("game", this);
    }

    @Override
    public void toMenu() {
        CmdMainView.getInstance().setState("menu");
    }

    @Override
    public void executeCommand(String name) {
        Optional.ofNullable(commandMap.get(name))
                .ifPresentOrElse(Runnable::run, () -> System.out.println("No such command"));
    }

    @Override
    public void disableControl() {
        commandMap.remove("back");
        commandMap.remove("forward");
        commandMap.remove("left");
        commandMap.remove("right");
    }

    @Override
    public void enableControl() {
        commandMap.put("back", controller::back);
        commandMap.put("forward", controller::forward);
        commandMap.put("left", controller::left);
        commandMap.put("right", controller::right);
    }

    @Override
    public void showHelp() {
        commandMap.keySet().stream().forEach(System.out::println);
    }

    @Override
    public void show(String message) {
        System.out.println(message);
    }

    @Override
    public void win() {
        System.out.println("You win!!");
    }
}
