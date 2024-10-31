package main.java.com.example.designpatterns.chp6_command.home_appliances;

public class GarageDoor {
    public void up() {
        System.out.println("Garage Door is open!");
    }

    public void down() {
        System.out.println("Garage Door is closed!");
    }

    public void stop() {
        System.out.println("Garage Door is stopped!");
    }

    public void lightOn() {
        System.out.println("Garage Door lights on!");
    }

    public void lightOff() {
        System.out.println("Garage Door lights off!");
    }
}
