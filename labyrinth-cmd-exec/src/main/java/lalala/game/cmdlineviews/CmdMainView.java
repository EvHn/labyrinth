package lalala.game.cmdlineviews;

import view.IViewFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CmdMainView {
    private Map<String, ICommandView> views;
    private ICommandView view;
    private static CmdMainView mainCmdMainView = new CmdMainView();
    private static CmdViewFactory cmdViewFactory = new CmdViewFactory();

    public static CmdMainView getInstance() {
        return mainCmdMainView;
    }

    public static IViewFactory getCmdViewFactory() {
        return cmdViewFactory;
    }

    public CmdMainView() {
        views = new HashMap<>();
    }

    public void putView(String name, ICommandView view) {
        views.put(name, view);
    }

    public void start() {
        view = views.get("menu");
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while(true) {
                view.executeCommand(scanner.nextLine());
            }
        }).start();
    }

    public void setState(String state) {
        view = views.get(state);
    }

    public void setState(String state, Map<String, String> options) {
        view = views.get(state);
        view.init(options);
    }
}
