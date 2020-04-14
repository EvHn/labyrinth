package lalala.game.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lalala.game.core.data.Level;
import lalala.game.core.data.LevelList;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.ServerEndpoint;
import java.nio.file.Path;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping("/levels")
    public LevelList getHome(Model model) throws Exception {
        return new ObjectMapper().readValue(Path.of("./backend/src/main/resources/levels.json").toFile(),
                LevelList.class);
    }
}
