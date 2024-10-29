package main.java.com.example.designpatterns.chp6_command.home_appliances;

public class CeilingFan {
    private final String name;

    public CeilingFan() {
        name = "";
    }

    public CeilingFan(final String name) {
        this.name = name;
    }

    public void high() {
        System.out.println(name + " ceilingFan is on high");
    }

    public void off() {
        System.out.println(name + " ceilingFan is off");
    }
}
