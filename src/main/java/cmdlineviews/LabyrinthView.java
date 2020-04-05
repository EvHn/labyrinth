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

    private static final String BACK = "back";
    private static final String FORWARD = "forward";
    private static final String LEFT = "left";
    private static final String RIGHT = "right";

    public LabyrinthView(ILabyrinthController controller, ILabyrinth model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver(this);
        commandMap = new HashMap<>();
        commandMap.put("exit", controller::exit);
        commandMap.put("start", controller::start);
        commandMap.put("help", controller::help);
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
        commandMap.remove(BACK);
        commandMap.remove(FORWARD);
        commandMap.remove(LEFT);
        commandMap.remove(RIGHT);
    }

    @Override
    public void enableControl() {
        commandMap.put(BACK, controller::back);
        commandMap.put(FORWARD, controller::forward);
        commandMap.put(LEFT, controller::left);
        commandMap.put(RIGHT, controller::right);
    }

    @Override
    public void disableBack() {
        commandMap.remove(BACK);
    }

    @Override
    public void enableBack() {
        commandMap.put(BACK, controller::back);
    }

    @Override
    public void disableForward() {
        commandMap.remove(FORWARD);
    }

    @Override
    public void enableForward() {
        commandMap.put(FORWARD, controller::forward);
    }

    @Override
    public void disableLeft() {
        commandMap.remove(LEFT);
    }

    @Override
    public void enableLeft() {
        commandMap.put(LEFT, controller::left);
    }

    @Override
    public void disableRight() {
        commandMap.remove(RIGHT);
    }

    @Override
    public void enableRight() {
        commandMap.put(RIGHT, controller::right);
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

    @Override
    public void init(Map<String, String> options) {
        controller.init(options);
    }
}
