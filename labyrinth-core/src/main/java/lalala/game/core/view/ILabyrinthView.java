package lalala.game.core.view;

public interface ILabyrinthView {
    void toMenu();
    void showHelp();
    void show(String message);

    void disableControl();
    void enableControl();

    void disableBack();
    void enableBack();

    void disableForward();
    void enableForward();

    void disableLeft();
    void enableLeft();

    void disableRight();
    void enableRight();
}
