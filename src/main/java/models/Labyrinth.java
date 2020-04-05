package models;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Labyrinth implements ILabyrinth {

    private Pair<Integer, Integer> coordinates;
    private List<ILabyrinthObserver> observers;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private char[][] field;
    private String levelName;

    public Labyrinth() {
        coordinates = Pair.of(1,1);
        this.observers = new ArrayList<>();
    }

    @Override
    public boolean goTo(Direction direction) {
        if(canGo(direction)) {
            moveTo(direction);
            if(isOverGame()) {
                notifyObservers();
                recordEndTime();
            }
            return true;
        }

        return false;
    }

    @Override
    public void start() {
        System.out.println("game started");
    }

    @Override
    public String getLevelName() {
        return levelName;
    }

    private boolean isOverGame() {
        return true;
    }

    private void moveTo(Direction direction) {
        switch(direction) {
            case BACK:
                coordinates = Pair.of(coordinates.getLeft(), coordinates.getRight() - 1);
                break;
            case LEFT:
                coordinates = Pair.of(coordinates.getLeft() - 1, coordinates.getRight());
                break;
            case RIGHT:
                coordinates = Pair.of(coordinates.getLeft() + 1, coordinates.getRight());
            case FORWARD:
                coordinates = Pair.of(coordinates.getLeft(), coordinates.getRight() + 1);
        }
    }

    private boolean canGo(Direction direction) {
        return false;
    }

    @Override
    public Pair<Integer, Integer> getCoordinates() {
        return coordinates;
    }

    @Override
    public void loadLevel(String name) {
        levelName = name;
        field = new char[][]{{'0', '0', '0'},
                             {'0', '0', '0'},
                             {'0', '0', '0'}};
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
