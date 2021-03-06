package lalala.game.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lalala.game.core.data.LevelList;
import lalala.game.core.data.Level;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

public class LocalDataLoader implements IDataLoader {
    private Path configPath;
    private ObjectMapper mapper;
    private LevelList config;

    public LocalDataLoader(String configPath) {
        mapper = new ObjectMapper();
        this.configPath = Path.of(configPath);
    }

    @Override
    public Optional<LevelList> loadConfig() {
        if(config == null) {
            synchronized(LevelList.class) {
                if(config == null) {
                    try {
                        return Optional.of(mapper.readValue(configPath.toFile(), LevelList.class));
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
