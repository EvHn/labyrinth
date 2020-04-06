package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Config;
import data.Level;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

public class LocalDataLoader implements IDataLoader {
    ObjectMapper mapper;
    Config config;

    public LocalDataLoader() {
        mapper = new ObjectMapper();
    }

    @Override
    public Optional<Config> loadConfig() {
        if(config == null) {
            synchronized(Config.class) {
                if(config == null) {
                    try {
                        Path path = Path.of("src/main/resources/config.json");
                        return Optional.of(mapper.readValue(path.toFile(), Config.class));
                    } catch (IOException ex) {
                        return Optional.empty();
                    }
                }
            }
        }
        return Optional.of(config);
    }

    @Override
    public Optional<Level> loadLevel(String name, Path path) {
        try {
            return Optional.of(mapper.readValue(path.toFile(), Level.class));
        } catch (IOException ex) {
            return Optional.empty();
        }
    }
}
