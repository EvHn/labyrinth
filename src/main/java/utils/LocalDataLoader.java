package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Config;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

public class LocalDataLoader implements IDataLoader {
    @Override
    public Optional<Config> loadConfig() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Path path = Path.of("src/main/resources/config.json");
            return Optional.of(mapper.readValue(path.toFile(), Config.class));
        } catch (IOException ex) {
            return Optional.empty();
        }
    }

    @Override
    public void loadLevel(String name) {

    }
}
