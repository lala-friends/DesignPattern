package main.java.com.example.designpatterns.chp12_compound;

public class Goose {
    public void honk() {
        System.out.println("Honk");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
