package lalala.game.cmd.cmdlineviews;


import lalala.game.mvc.view.IViewFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CmdViewManager {
    private Map<String, ICommandView> views;
    private ICommandView view;
    private static CmdViewManager mainCmdMainView = new CmdViewManager();
    private static CmdViewFactory cmdViewFactory = new CmdViewFactory();

    public static CmdViewManager getInstance() {
        return mainCmdMainView;
    }

    public static IViewFactory getCmdViewFactory() {
        return cmdViewFactory;
    }

    public CmdViewManager() {
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
