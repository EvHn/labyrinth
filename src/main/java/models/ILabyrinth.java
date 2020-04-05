package models;

import org.apache.commons.lang3.tuple.Pair;

import java.time.Duration;

public interface ILabyrinth {
    boolean goTo(Direction direction);
    boolean canGoTo(Direction direction);
    Pair<Integer, Integer> getCoordinates();
    void loadLevel(String name);
    String getLevelName();
    void recordStartTime();
    void recordEndTime();
    Duration getGameTime();
    void start();
    void registerObserver(ILabyrinthObserver observer);
    void removeObserver(ILabyrinthObserver observer);
    enum Direction {
        FORWARD,
        BACK,
        LEFT,
        RIGHT
    }
}
