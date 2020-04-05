package controllers;

public interface ILabyrinthController {
    void start(String levelName);
    void restart();
    void back();
    void forward();
    void left();
    void right();
    void help();
    void exit();
}
