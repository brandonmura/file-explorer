package commands;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    private final List<Command> history = new ArrayList<>();

    public void execute(Command command) {
        command.execute();
        history.add(command);
    }
}
