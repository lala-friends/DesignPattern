package test.java.com.example.designpatterns.chp6_command;

import main.java.com.example.designpatterns.chp6_command.*;
import org.junit.jupiter.api.Test;

public class CommandTest {
    @Test
    public void testSimpleRemoteControl() {
        final var remote = new SimpleRemoteControl();

        final var light = new Light();
        final var lightOnCommand = new LightOnCommand(light);

        remote.setCommand(lightOnCommand);
        remote.buttonWasPressed();

        final var garageDoor = new GarageDoor();
        final var garageOnCommand = new GarageDoorOpenCommand(garageDoor);

        remote.setCommand(garageOnCommand);
        remote.buttonWasPressed();
    }
}
