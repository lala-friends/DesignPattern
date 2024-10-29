package test.java.com.example.designpatterns.chp6_command;

import main.java.com.example.designpatterns.chp6_command.RemoteControl;
import main.java.com.example.designpatterns.chp6_command.SimpleRemoteControl;
import main.java.com.example.designpatterns.chp6_command.command.*;
import main.java.com.example.designpatterns.chp6_command.home_appliances.CeilingFan;
import main.java.com.example.designpatterns.chp6_command.home_appliances.GarageDoor;
import main.java.com.example.designpatterns.chp6_command.home_appliances.Light;
import main.java.com.example.designpatterns.chp6_command.home_appliances.Stereo;
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

    @Test
    void testRemoteControl() {
        final var remoteControl = new RemoteControl();

        final var lightForLivingRoom = new Light("Living Room");
        final var lightOnCommandForLivingRoom = new LightOnCommand(lightForLivingRoom);
        final var lightOffCommandForLivingRoom = new LightOffCommand(lightForLivingRoom);

        final var lightForKitchen = new Light("Kitchen");
        final var lightOnCommandForKitchen = new LightOnCommand(lightForKitchen);
        final var lightOffCommandForKitchen = new LightOffCommand(lightForKitchen);

        final var ceilingFan = new CeilingFan("Living Room");
        final var ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        final var ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        final var garageDoor = new GarageDoor();
        final var garageOnCommand = new GarageDoorOpenCommand(garageDoor);
        final var garageCloseCommand = new GarageDoorCloseCommand(garageDoor);

        final var stereo = new Stereo("Living Room");
        final var stereoOnForCDCommand = new StereoOnForCDCommand(stereo);
        final var stereoOffCommand = new StereoOffCommand(stereo);

        remoteControl.setCommand(0, lightOnCommandForLivingRoom, lightOffCommandForLivingRoom);
        remoteControl.setCommand(1, lightOnCommandForKitchen, lightOffCommandForKitchen);
        remoteControl.setCommand(2, ceilingFanHighCommand, ceilingFanOffCommand);
        remoteControl.setCommand(3, garageOnCommand, garageCloseCommand);
        remoteControl.setCommand(4, stereoOnForCDCommand, stereoOffCommand);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPressed(0);
        remoteControl.offButtonWasPressed(0);
        remoteControl.onButtonWasPressed(1);
        remoteControl.offButtonWasPressed(1);
        remoteControl.onButtonWasPressed(2);
        remoteControl.offButtonWasPressed(2);
        remoteControl.onButtonWasPressed(3);
        remoteControl.offButtonWasPressed(3);
        remoteControl.onButtonWasPressed(4);
        remoteControl.offButtonWasPressed(4);
    }
}
