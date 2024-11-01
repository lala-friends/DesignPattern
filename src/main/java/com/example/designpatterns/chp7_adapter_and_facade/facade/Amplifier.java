package main.java.com.example.designpatterns.chp7_adapter_and_facade.facade;

public class Amplifier {
    public void on() {
        System.out.println("Top-O-Line Amplifier on");
    }

    public void setDvd(final DvdPlayer dvdPlayer) {
        System.out.println("Top-O-Line Amplifier setting DVD player to Top-O-Line DVD Player");
    }

    public void setSurroundSound() {
        System.out.println("Top-O-Line Amplifier surround sound on (5 speakers, 1 subwoofer)");
    }

    public void setVolume(int volume) {
        System.out.println("Top-O-Line Amplifier setting volume to " + volume);
    }

    public void off() {
        System.out.println("Top-O-Line Amplifier off");
    }
}
