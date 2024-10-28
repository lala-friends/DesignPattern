package main.java.com.example.designpatterns.chp6_command;

public class GarageDoorOpenCommand implements Command {
    private final GarageDoor garageDoor;

    public GarageDoorOpenCommand(final GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.open();
    }
}
