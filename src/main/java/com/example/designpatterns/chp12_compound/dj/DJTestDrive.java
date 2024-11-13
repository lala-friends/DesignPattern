package main.java.com.example.designpatterns.chp12_compound.dj;

public class DJTestDrive {
    public static void main(String[] args) {
        final var model = new BeatModel();
        final var controller = new BeatController(model);
    }
}
