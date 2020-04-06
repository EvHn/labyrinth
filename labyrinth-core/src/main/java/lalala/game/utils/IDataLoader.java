package utils;

import data.Config;
import data.Level;

import java.nio.file.Path;
import java.util.Optional;

public interface IDataLoader {
    Optional<Config> loadConfig();
    Optional<Level> loadLevel(String name, Path path);
}
