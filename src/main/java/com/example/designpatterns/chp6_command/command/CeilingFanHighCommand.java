package main.java.com.example.designpatterns.chp6_command.command;

import main.java.com.example.designpatterns.chp6_command.home_appliances.CeilingFan;

public class CeilingFanHighCommand implements Command {
    private final CeilingFan ceilingFan;

    public CeilingFanHighCommand(final CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.high();
    }
}
