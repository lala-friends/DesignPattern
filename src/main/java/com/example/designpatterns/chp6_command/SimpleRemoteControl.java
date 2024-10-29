package main.java.com.example.designpatterns.chp6_command;

import main.java.com.example.designpatterns.chp6_command.command.Command;

public class SimpleRemoteControl {
    private Command command;

    public SimpleRemoteControl() {
    }

    public void setCommand(final Command command) {
        this.command = command;
    }

    public void buttonWasPressed() {
        command.execute();
    }
}
