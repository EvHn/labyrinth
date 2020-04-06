package lalala.game.core.utils;


import lalala.game.core.data.Config;
import lalala.game.core.data.Level;

import java.nio.file.Path;
import java.util.Optional;

public interface IDataLoader {
    Optional<Config> loadConfig();
    Optional<Level> loadLevel(String name, Path path);
}
