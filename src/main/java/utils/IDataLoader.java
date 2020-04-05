package utils;

import data.Config;

import java.util.Optional;

public interface IDataLoader {
    Optional<Config> loadConfig();
    void loadLevel(String name);
}
