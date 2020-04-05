package cmdlineviews;

import java.util.Map;

public interface ICommandView {
    void init(Map<String, String> options);
    void executeCommand(String name);
}
