package main.java.com.example.designpatterns.chp6_command.command;

public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("No command");
    }

    @Override
    public void undo() {
        System.out.println("No command");
    }
}
