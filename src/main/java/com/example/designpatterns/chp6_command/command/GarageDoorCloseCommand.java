package main.java.com.example.designpatterns.chp6_command.command;

import main.java.com.example.designpatterns.chp6_command.home_appliances.GarageDoor;

public class GarageDoorCloseCommand implements Command {
    private final GarageDoor garageDoor;

    public GarageDoorCloseCommand(final GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.close();
    }
}
