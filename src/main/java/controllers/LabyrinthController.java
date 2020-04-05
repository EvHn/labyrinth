package controllers;

import models.ILabyrinth;
import models.ILabyrinthObserver;
import view.ILabyrinthView;
import view.IViewFactory;

public class LabyrinthController implements ILabyrinthController, ILabyrinthObserver {
    private ILabyrinth model;
    private ILabyrinthView view;

    public LabyrinthController(ILabyrinth model, IViewFactory factory) {
        this.model = model;
        model.registerObserver(this);
        this.view = factory.createLabyrinthView(this, model);
    }

    @Override
    public void start(String levelName) {
        model.loadLevel(levelName);
        view.enableControl();
    }

    @Override
    public void restart() {
        model.loadLevel(model.getLevelName());
        view.enableControl();
    }

    @Override
    public void back() {
        goTo(ILabyrinth.Direction.BACK);
    }

    @Override
    public void forward() {
        goTo(ILabyrinth.Direction.FORWARD);
    }

    @Override
    public void left() {
        goTo(ILabyrinth.Direction.LEFT);
    }

    @Override
    public void right() {
        goTo(ILabyrinth.Direction.RIGHT);
    }

    private void goTo(ILabyrinth.Direction direction) {
        if(model.goTo(direction)) {
            view.show("go");
        } else {
            view.show("You can't go to " + direction);
        }
    }

    @Override
    public void exit() {
        view.toMenu();
    }

    @Override
    public void help() {
        view.showHelp();
    }

    @Override
    public void win() {
        view.disableControl();
    }
}
