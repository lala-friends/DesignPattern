package main.java.com.example.designpatterns.chp6_command.command;

import main.java.com.example.designpatterns.chp6_command.home_appliances.CeilingFan;

public class CeilingFanOffCommand implements Command {
    private final CeilingFan ceilingFan;
    private int previousSpeed;

    public CeilingFanOffCommand(final CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    @Override
    public void undo() {
        switch (previousSpeed) {
            case CeilingFan.HIGH -> ceilingFan.high();
            case CeilingFan.MEDIUM -> ceilingFan.medium();
            case CeilingFan.LOW -> ceilingFan.low();
            case CeilingFan.OFF -> ceilingFan.off();
        }
    }
}
