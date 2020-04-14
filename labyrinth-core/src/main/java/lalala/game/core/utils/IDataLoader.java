package lalala.game.core.utils;


import lalala.game.core.data.LevelList;
import lalala.game.core.data.Level;

import java.nio.file.Path;
import java.util.Optional;

public interface IDataLoader {
    Optional<LevelList> loadConfig();
    Optional<Level> loadLevel(String name, Path path);
}
