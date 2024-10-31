package main.java.com.example.designpatterns.chp6_command.command;

import main.java.com.example.designpatterns.chp6_command.home_appliances.GarageDoor;

public class GarageDoorOpenCommand implements Command {
    private final GarageDoor garageDoor;

    public GarageDoorOpenCommand(final GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {
        garageDoor.down();
    }
}
