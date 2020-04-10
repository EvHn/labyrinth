package lalala.game.mvc.models;

import lalala.game.core.data.Config;
import lalala.game.core.data.Level;
import lalala.game.core.labyrinth.Direction;
import lalala.game.core.labyrinth.ILabyrinthHelper;
import lalala.game.core.labyrinth.LabyrinthHelper;
import lalala.game.core.utils.IDataLoader;
import org.apache.commons.lang3.tuple.Pair;

import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;


public class Labyrinth implements ILabyrinth {
    private Pair<Integer, Integer> coordinates;
    private List<ILabyrinthObserver> observers;
    private IDataLoader dataLoader;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Level level;
    private List<Character> correctPlaces;
    private ILabyrinthHelper labyrinthHelper;

    public Labyrinth() {

        this.observers = new ArrayList<>();
        labyrinthHelper = new LabyrinthHelper();
    }

    public void setStartPlace() {
            coordinates = labyrinthHelper.getStartPosition(level);
    }

    @Override
    public void setDataLoader(IDataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @Override
    public void goTo(Direction direction) {
        coordinates = labyrinthHelper.moveTo(coordinates, direction);
        if(isOverGame()) {
            notifyObservers();
            recordEndTime();
        }
    }

    @Override
    public String getLevelName() {
        return level.getName();
    }

    private boolean isOverGame() {
        return level.getField().get(coordinates.getRight()).get(coordinates.getLeft()).equals('f');
    }

    public boolean canGoTo(Direction direction) {
        Pair<Integer, Integer> place = labyrinthHelper.moveTo(coordinates, direction);

        return false;
    }

    @Override
    public Pair<Integer, Integer> getCoordinates() {
        return coordinates;
    }

    @Override
    public boolean loadLevel(String name) {
        Optional<Config> config = dataLoader.loadConfig();
        if(config.isPresent()) {
            Optional<Level> level = dataLoader.loadLevel(name, Path.of(config.get().getLevels().get(name)));
            if(level.isPresent()) {
                this.level = level.get();
                return true;
            }
        }
        return false;
    }

    @Override
    public void recordStartTime() {
        startTime = LocalDateTime.now();
    }

    @Override
    public void recordEndTime() {
        endTime = LocalDateTime.now();
    }

    @Override
    public Duration getGameTime() {
        return Duration.between(startTime, endTime);
    }

    private void notifyObservers() {
        observers.stream().forEach(observer -> observer.win());
    }

    @Override
    public void registerObserver(ILabyrinthObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ILabyrinthObserver observer) {
        observers.remove(observer);
    }
}
