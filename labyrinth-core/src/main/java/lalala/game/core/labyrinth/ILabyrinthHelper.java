package lalala.game.core.labyrinth;

import lalala.game.core.data.Level;
import org.apache.commons.lang3.tuple.Pair;

public interface ILabyrinthHelper {
    Pair<Integer, Integer> moveTo(Pair<Integer, Integer> coordinates, Direction direction);
    Pair<Integer, Integer> getStartPosition(Level level);
    boolean canGoTo(Level level, Pair<Integer, Integer> location);
}
