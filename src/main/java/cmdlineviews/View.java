package cmdlineviews;

import java.util.List;
import java.util.Map;

public class View {
    List<ICommandView> views;
    ICommandView view;

    public View(Map<String, ICommandView> views) {
        view = views.get("menu");
    }

    public void executeCommand(String name) {
        view.executeCommand(name);
    }
}
