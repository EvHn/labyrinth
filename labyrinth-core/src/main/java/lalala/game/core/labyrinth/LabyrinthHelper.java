package lalala.game.core.labyrinth;

import lalala.game.core.data.Level;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Optional;

public class LabyrinthHelper implements ILabyrinthHelper {

    private static char START = 's';
    private static char FINISH = 'f';
    private static char SPACE = '0';
    private static List<Character> correctPlaces = List.of(START, FINISH, SPACE);

    public Pair<Integer, Integer> moveTo(Pair<Integer, Integer> coordinates, Direction direction) {
        switch(direction) {
            case BACK:
                return Pair.of(coordinates.getLeft(), coordinates.getRight() - 1);
            case LEFT:
                return Pair.of(coordinates.getLeft() + 1, coordinates.getRight());
            case RIGHT:
                return Pair.of(coordinates.getLeft() - 1, coordinates.getRight());
            case FORWARD:
                return Pair.of(coordinates.getLeft(), coordinates.getRight() + 1);
            default:
                return coordinates;
        }
    }

    @Override
    public Pair<Integer, Integer> getStartPosition(Level level) {
        Optional<List<Character>> line = level.getField().stream().filter(l -> l.contains('s')).findAny();
        if(line.isPresent()) {
            return Pair.of(line.get().indexOf(START), level.getField().indexOf(line.get()));
        }
        return Pair.of(0,0);
    }

    @Override
    public boolean canGoTo(Level level, Pair<Integer, Integer> location) {
        List<List<Character>> field = level.getField();
        Integer y = location.getRight();
        if(y < field.size() && y >= 0) {
            List<Character> row = level.getField().get(y);
            Integer x = location.getLeft();
            if(x < row.size() && x >= 0) {
                return correctPlaces.contains(row.get(x));
            }
        }
        return false;
    }


}
