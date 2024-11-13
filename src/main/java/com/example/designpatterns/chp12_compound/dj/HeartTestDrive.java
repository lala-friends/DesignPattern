package main.java.com.example.designpatterns.chp12_compound.dj;

public class HeartTestDrive {
    public static void main(String[] args) {
        final var heardModel = new HeartModel();
        final var controller = new HeartController(heardModel);
    }
}
