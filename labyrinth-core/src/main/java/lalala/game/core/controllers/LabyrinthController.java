package lalala.game.core.controllers;

import lalala.game.core.models.ILabyrinth;
import lalala.game.core.models.ILabyrinthObserver;
import lalala.game.core.utils.IUtilsFactory;
import lalala.game.core.view.ILabyrinthView;
import lalala.game.core.view.IViewFactory;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class LabyrinthController implements ILabyrinthController, ILabyrinthObserver {
    private ILabyrinth model;
    private ILabyrinthView view;
    private Map<ILabyrinth.Direction, Pair<Runnable, Runnable>> control;

    public LabyrinthController(ILabyrinth model, IViewFactory factory, IUtilsFactory utilsFactory) {
        this.model = model;
        model.setDataLoader(utilsFactory.createDataLoader());
        model.registerObserver(this);
        this.view = factory.createLabyrinthView(this, model);
        control = new HashMap<>();
        control.put(ILabyrinth.Direction.RIGHT, Pair.of(view::enableRight, view::disableRight));
        control.put(ILabyrinth.Direction.LEFT, Pair.of(view::enableLeft, view::disableLeft));
        control.put(ILabyrinth.Direction.BACK, Pair.of(view::enableBack, view::disableBack));
        control.put(ILabyrinth.Direction.FORWARD, Pair.of(view::enableForward, view::disableForward));
    }

    @Override
    public void init(Map<String, String> options) {
        if(model.loadLevel(options.get("levelName"))) {
            model.setStartPlace();
            return;
        }
        view.show("Error loading level");
        exit();
    }

    @Override
    public void start() {
        model.recordStartTime();
        setControl();
    }

    @Override
    public void restart() {
        model.loadLevel(model.getLevelName());
        setControl();
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
        if(model.canGoTo(direction)) {
            view.show("You go " + direction);
            model.goTo(direction);
            setControl();
        } else {
            view.show("You can't go " + direction);
        }
    }

    private void setControl() {
        control.entrySet().stream().map(entry -> {
                if(model.canGoTo(entry.getKey())) {
                    return entry.getValue().getLeft();
                }
                return entry.getValue().getRight();
        }).forEach(Runnable::run);
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
