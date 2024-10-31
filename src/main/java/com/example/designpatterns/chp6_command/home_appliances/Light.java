package main.java.com.example.designpatterns.chp6_command.home_appliances;

public class Light {
    private final String name;

    public Light() {
        name = "";
    }

    public Light(final String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + " Light is on");
    }

    public void off() {
        System.out.println(name + " Light is off");
    }
}
