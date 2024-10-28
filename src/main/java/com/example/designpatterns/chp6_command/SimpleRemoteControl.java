package main.java.com.example.designpatterns.chp6_command;

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
