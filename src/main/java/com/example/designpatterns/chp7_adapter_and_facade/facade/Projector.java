package main.java.com.example.designpatterns.chp7_adapter_and_facade.facade;

public class Projector {
    public void on() {
        System.out.println("Top-O-Line Projector on");
    }

    public void wideScreenMode() {
        System.out.println("Top-O-Line Projector in widescreen mode (16X9 aspect ratio)");
    }

    public void off() {
        System.out.println("Top-O-Line Projector off");
    }
}
