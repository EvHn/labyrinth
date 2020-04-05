package models;

import data.Config;
import data.Level;
import org.apache.commons.lang3.tuple.Pair;
import utils.IDataLoader;

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
    private List<Character> correctPlace;

    public Labyrinth() {
        coordinates = Pair.of(1,1);
        correctPlace = List.of('0', 'f', 's');
        this.observers = new ArrayList<>();
    }

    @Override
    public void setDataLoader(IDataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @Override
    public void goTo(Direction direction) {
        coordinates = moveTo(coordinates, direction);
        if(isOverGame()) {
            notifyObservers();
            recordEndTime();
        }
    }

    @Override
    public void start() {

    }

    @Override
    public String getLevelName() {
        return level.getName();
    }

    private boolean isOverGame() {
        return level.getField().get(coordinates.getRight()).get(coordinates.getLeft()).equals('f');
    }

    private Pair<Integer, Integer> moveTo(Pair<Integer, Integer> coordinates, Direction direction) {
        switch(direction) {
            case BACK:
                return Pair.of(coordinates.getLeft(), coordinates.getRight() - 1);
            case LEFT:
                return Pair.of(coordinates.getLeft() - 1, coordinates.getRight());
            case RIGHT:
                return Pair.of(coordinates.getLeft() + 1, coordinates.getRight());
            case FORWARD:
                return Pair.of(coordinates.getLeft(), coordinates.getRight() + 1);
            default:
                return coordinates;
        }
    }

    public boolean canGoTo(Direction direction) {
        Pair<Integer, Integer> place = moveTo(coordinates, direction);
        List<List<Character>> field = level.getField();
        Integer y = place.getRight();
        if(y < field.size() && y >= 0) {
            List<Character> row = level.getField().get(y);
            Integer x = place.getLeft();
            if(x < row.size() && x >= 0) {
                return correctPlace.contains(row.get(place.getLeft()));
            }
        }
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
