package main.java.com.example.designpatterns.chp6_command;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(final Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
