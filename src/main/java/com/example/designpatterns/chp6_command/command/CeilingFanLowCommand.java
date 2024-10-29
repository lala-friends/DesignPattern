package main.java.com.example.designpatterns.chp6_command.command;

import main.java.com.example.designpatterns.chp6_command.home_appliances.CeilingFan;

public class CeilingFanLowCommand implements Command {
    private final CeilingFan ceilingFan;
    private int previousSpeed;

    public CeilingFanLowCommand(final CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.low();
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
