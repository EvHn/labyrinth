package lalala.game.mvc.controllers;

import java.util.Map;

public interface ILabyrinthController {
    void init(Map<String, String> options);
    void start();
    void restart();
    void back();
    void forward();
    void left();
    void right();
    void help();
    void exit();
}
