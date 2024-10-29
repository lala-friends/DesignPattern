package main.java.com.example.designpatterns.chp6_command.command;

public class MacroCommand implements Command {
    private final Command[] commands;

    public MacroCommand(final Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }
}
