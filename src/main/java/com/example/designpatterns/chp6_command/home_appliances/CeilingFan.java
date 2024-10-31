package main.java.com.example.designpatterns.chp6_command.home_appliances;

public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    private final String name;


    private int speed;

    public CeilingFan() {
        name = "";
    }

    public CeilingFan(final String name) {
        this.name = name;
    }

    public void high() {
        setSpeed(HIGH);
        System.out.println(name + " ceiling fan is on high");
    }

    public void medium() {
        setSpeed(MEDIUM);
        System.out.println(name + " ceiling fan is on medium");
    }

    public void low() {
        setSpeed(LOW);
        System.out.println(name + " ceiling fan is on low");
    }

    public void off() {
        setSpeed(OFF);
        System.out.println(name + " ceiling fan is on off");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
