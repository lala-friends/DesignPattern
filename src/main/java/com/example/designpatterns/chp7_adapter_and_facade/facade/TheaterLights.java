package main.java.com.example.designpatterns.chp7_adapter_and_facade.facade;

public class TheaterLights {
    private int luminosity;

    public void on() {
        luminosity = 100;
    }

    public void off() {
        luminosity = 0;
    }

    public void dim(final int value) {
        System.out.println("Theater Ceiling Lights dimming to 10%");
        this.luminosity = this.luminosity * value / 100;
    }
}
